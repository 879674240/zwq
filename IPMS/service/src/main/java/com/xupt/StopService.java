package com.xupt;

import com.xupt.dal.mapper.*;
import com.xupt.dal.model.*;
import com.xupt.dto.ParkingInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StopService {
    @Resource
    StopMapper stopMapper;
    @Resource
    ParkingMapper parkingMapper;
    @Resource
    CardinfoMapper cardinfoMapper;
    @Resource
    UserinfoMapper userinfoMapper;
    @Resource
    CarinfoMapper carinfoMapper;
    @Resource
    CollectMapper collectMapper;
    /**
     * 添加停车信息
     * @param stopEntity
     * @return
     */
    public int insert(StopEntity stopEntity){
        int result = 0;
        StopEntity stopEntity1 = stopMapper.queryByCardno(stopEntity.getCardno());
        if(stopEntity1!=null){
            return result;
        }
        result = stopMapper.insert(stopEntity);
        ParkingEntity parkingEntity = new ParkingEntity();
        parkingEntity.setPosition(stopEntity.getCarposi());
        parkingEntity.setStatus(1);
        parkingMapper.updateByPosi(parkingEntity);

        CollectEntity collectEntity = new CollectEntity();
        CarinfoEntity carinfoEntity = carinfoMapper.queryCarnum(stopEntity.getCarnum());
        String carddriverno = carinfoEntity.getCardriverno();
        UserinfoEntity userinfoEntity = userinfoMapper.queryByCardriverno(carddriverno);
        collectEntity.setUsername(userinfoEntity.getUsername());
        CardinfoEntity cardinfoEntity = cardinfoMapper.queryByIdno(userinfoEntity.getIdno());
        collectEntity.setCardno(cardinfoEntity.getCardno());
        collectEntity.setCarnum(stopEntity.getCarnum());
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        collectEntity.setStarttime(sf.format(date));
        collectMapper.insert(collectEntity);
        return result;
    }

    public List<ParkingEntity> queryPark(){
        List<ParkingEntity> parkingEntities = parkingMapper.query();
        return parkingEntities;
    }

    public ParkingInfo queryByCarnum(String carnum){
        ParkingInfo parkingInfo = new ParkingInfo();
        CarinfoEntity carinfoEntity = carinfoMapper.queryCarnum(carnum);
        parkingInfo.setType(carinfoEntity.getType());
        parkingInfo.setCarnum(carnum);
        String carddriverno = carinfoEntity.getCardriverno();
        UserinfoEntity userinfoEntity = userinfoMapper.queryByCardriverno(carddriverno);
        CardinfoEntity cardinfoEntity = cardinfoMapper.queryByIdno(userinfoEntity.getIdno());
        parkingInfo.setCardno(cardinfoEntity.getCardno());
        String types;
        if(cardinfoEntity.getTypes().equals("临时卡")){
            types = "临时车辆收费";
        }else{
            types = "固定车辆收费";
        }
        parkingInfo.setTypes(types);
        return parkingInfo;
    }

    public StopEntity querySpace(String carnum){
        StopEntity stopEntity = stopMapper.queryByCarnum(carnum);
        return stopEntity;
    }
}
