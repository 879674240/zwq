package com.xupt;

import com.xupt.dal.mapper.*;
import com.xupt.dal.model.*;
import com.xupt.dto.PreStopDTO;
import com.xupt.dto.TempStopDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FeeManageService {
    @Resource
    FeessetMapper feessetMapper;
    @Resource
    CardinfoMapper cardinfoMapper;
    @Resource
    UserinfoMapper userinfoMapper;
    @Resource
    CarinfoMapper carinfoMapper;
    @Resource
    CollectMapper collectMapper;
    @Resource
    StopMapper stopMapper;
    @Resource
    ParkingMapper parkingMapper;

    public int insertFeeset(FeessetEntity feessetEntity){
        int result;
        result = feessetMapper.insert(feessetEntity);
        return result;
    }

    public TempStopDTO tempStop(String carnum){
        TempStopDTO tempStopDTO = new TempStopDTO();
        CarinfoEntity carinfoEntity = carinfoMapper.queryCarnum(carnum);
        String carddriverno = carinfoEntity.getCardriverno();
        UserinfoEntity userinfoEntity = userinfoMapper.queryByCardriverno(carddriverno);
        tempStopDTO.setUsername(userinfoEntity.getUsername());
        CardinfoEntity cardinfoEntity = cardinfoMapper.queryByIdno(userinfoEntity.getIdno());
        if(cardinfoEntity.getTypes().equals("长期卡")){
            TempStopDTO tempStopDTO1 = new TempStopDTO();
            tempStopDTO1.setCarnum("-1");
            return tempStopDTO1;
        }
        CollectEntity collectEntity = collectMapper.queryByCarnum(carnum);
        List<FeessetEntity> feessetEntitys = feessetMapper.queryByCardtype(cardinfoEntity.getTypes());
        FeessetEntity feessetEntity = new FeessetEntity();
        for (FeessetEntity feessetEntity1:feessetEntitys){
            feessetEntity = feessetEntity1;
        }
        tempStopDTO.setCardnum(cardinfoEntity.getCardno());
        tempStopDTO.setCarnum(carnum);
        tempStopDTO.setCarStart(collectEntity.getStarttime());
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        tempStopDTO.setCarend(sf.format(date));
        Date date1;
        int totalMoney = cardinfoEntity.getRemain();
        long money = 0;
        try {
            date1 = sf.parse(collectEntity.getStarttime());
            long temp = (date.getTime() - date1.getTime())/(60*1000);
            money = (temp/feessetEntity.getUnittime())*feessetEntity.getUnitmoney();
            tempStopDTO.setMoney(new Long(money).intValue());
            CollectEntity collectEntity1 = new CollectEntity();
            collectEntity1.setCarnum(carnum);
            collectEntity1.setEndtime(sf.format(date));
            collectEntity1.setTotalmoney(new Long(money).intValue());
            collectMapper.updateByCarnum(collectEntity1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tempStopDTO;
    }

    public int tempCal(String carnum){
        int result = 0;
        CarinfoEntity carinfoEntity = carinfoMapper.queryCarnum(carnum);
        String carddriverno = carinfoEntity.getCardriverno();
        UserinfoEntity userinfoEntity = userinfoMapper.queryByCardriverno(carddriverno);
        CardinfoEntity cardinfoEntity = cardinfoMapper.queryByIdno(userinfoEntity.getIdno());
        CollectEntity collectEntity = collectMapper.queryByCarnum(carnum);
        int money = cardinfoEntity.getRemain()-collectEntity.getTotalmoney();
        if (money>=0){
            CardinfoEntity cardinfoEntity1 = new CardinfoEntity();
            cardinfoEntity1.setCardno(cardinfoEntity.getCardno());
            cardinfoEntity1.setRemain(money);
            result = cardinfoMapper.updateByCardno(cardinfoEntity1);
            String carposi = stopMapper.queryByCardno(cardinfoEntity.getCardno()).getCarposi();
            stopMapper.deleteByCarnum(carnum);
            collectMapper.deleteByCarnum(carnum);
            ParkingEntity parkingEntity = new ParkingEntity();
            parkingEntity.setPosition(carposi);
            parkingEntity.setStatus(0);
            parkingMapper.updateByPosi(parkingEntity);
        }else{
            return 0;
        }
        return result;
    }

    public PreStopDTO preCal(String carnum){
        CarinfoEntity carinfoEntity = carinfoMapper.queryCarnum(carnum);
        String carddriverno = carinfoEntity.getCardriverno();
        UserinfoEntity userinfoEntity = userinfoMapper.queryByCardriverno(carddriverno);
        CardinfoEntity cardinfoEntity = cardinfoMapper.queryByIdno(userinfoEntity.getIdno());
        if(cardinfoEntity.getTypes().equals("临时卡")){
            PreStopDTO preStopDTO2 = new PreStopDTO();
            preStopDTO2.setCarnum("-2");
            return preStopDTO2;
        }
        PreStopDTO preStopDTO = new PreStopDTO();
        preStopDTO.setStatus(100);
        preStopDTO.setUsername(userinfoEntity.getUsername());
        preStopDTO.setCardnum(cardinfoEntity.getCardno());
        preStopDTO.setCarnum(carinfoEntity.getCarnum());
        preStopDTO.setCardStart(cardinfoEntity.getCarstart());
        preStopDTO.setCardend(cardinfoEntity.getCarend());
        Date date = new Date();
        SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        preStopDTO.setNowtime(sf.format(date));
        long temp;
        try {
             temp = date.getTime()-sf.parse(cardinfoEntity.getCarend()).getTime();
             if(temp>=0){
                 StopEntity stopEntity = stopMapper.queryByCardno(cardinfoEntity.getCardno());
                 if(stopEntity==null){
                     preStopDTO.setStatus(1);
                     return preStopDTO;
                 }
                 String carposi = stopEntity.getCarposi();
                 stopMapper.deleteByCarnum(carnum);
                 collectMapper.deleteByCarnum(carnum);
                 CardinfoEntity cardinfoEntity1 = new CardinfoEntity();
                 cardinfoEntity1.setRemain(0);
                 cardinfoEntity1.setCardno(cardinfoEntity.getCardno());
                 cardinfoMapper.updateByCardno(cardinfoEntity1);
                 ParkingEntity parkingEntity = new ParkingEntity();
                 parkingEntity.setPosition(carposi);
                 parkingEntity.setStatus(0);
                 parkingMapper.updateByPosi(parkingEntity);
                 preStopDTO.setStatus(2);
                return preStopDTO;
             }
        }catch (Exception e){
            e.printStackTrace();
        }

        return preStopDTO;
    }
}
