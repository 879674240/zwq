package com.xupt;

import com.xupt.common.PageResult;
import com.xupt.dal.dto.CardinfoDTO;
import com.xupt.dal.mapper.CardinfoMapper;
import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.CardinfoEntity;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.dto.CardinfoParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CardinfoService {
    @Resource
    CardinfoMapper cardinfoMapper;
    @Resource
    UserinfoMapper userinfoMapper;
    /**
     * 分页查询
     * @param cardinfoParam
     * @return
     */
    public PageResult<List<CardinfoEntity>> query(CardinfoParam cardinfoParam){
        PageResult<List<CardinfoEntity>> pageResult = new PageResult<>();
        CardinfoDTO cardinfoDTO = new CardinfoDTO();
        BeanUtils.copyProperties(cardinfoParam,cardinfoDTO);
        cardinfoDTO.setOffset((cardinfoParam.getCurrentPage()-1)*cardinfoParam.getPageSize());
        List<CardinfoEntity> cardinfoEntities = cardinfoMapper.query(cardinfoDTO);
        int count = cardinfoMapper.count(cardinfoDTO);
        pageResult.setData(cardinfoEntities);
        pageResult.setCount(count);
        pageResult.setCurrentPage(cardinfoParam.getCurrentPage());
        pageResult.setPageSize(cardinfoParam.getPageSize());
        return pageResult;
    }

    /**
     * 添加
     * @param cardinfoEntity
     * @return
     */
    public int insert(CardinfoEntity cardinfoEntity){
        int result = 0;
        CardinfoEntity cardinfoEntity1 = cardinfoMapper.queryByCardno(cardinfoEntity.getCardno());
        if (cardinfoEntity1!=null){
            return result;
        }
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        cardinfoEntity.setCarstart(sf.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,18*30);
        Date date1 = cal.getTime();
        cardinfoEntity.setCarend(sf.format(date1));
        if(cardinfoEntity.getTypes().equals("临时卡")){
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH,7);
            cardinfoEntity.setCarend(sf.format(cal.getTime()));
        }
        result =  cardinfoMapper.insert(cardinfoEntity);
        return result;
    }

    /**
     * 充值
     * @param cardinfoEntity
     * @return
     */
    public int update(CardinfoEntity cardinfoEntity){
        int result = 0;
        if(cardinfoEntity.getTypes().equals("长期卡")){

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = null;
            Date date1 = null;
            Calendar cal = Calendar.getInstance();
            try {
                date = sf.parse(cardinfoEntity.getCarend());
                cal.setTime(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(cardinfoEntity.getRemain()==100){
                cal.add(Calendar.DAY_OF_MONTH,6*30);
                date1 = cal.getTime();
                cardinfoEntity.setCarend(sf.format(date1));
            }else if(cardinfoEntity.getRemain()==300){
                cal.add(Calendar.DAY_OF_MONTH,18*30);
                date1 = cal.getTime();
                cardinfoEntity.setCarend(sf.format(date1));
            }else if(cardinfoEntity.getRemain()==500){
                cal.add(Calendar.DAY_OF_MONTH,30*30);
                date1 = cal.getTime();
                cardinfoEntity.setCarend(sf.format(date1));
            }
        }else{
            CardinfoEntity cardinfoEntity1 = cardinfoMapper.queryById(cardinfoEntity.getId());
            cardinfoEntity.setRemain(cardinfoEntity1.getRemain()+cardinfoEntity.getRemain());
        }
        result = cardinfoMapper.update(cardinfoEntity);
        return result;
    }

    /**
     * 批量删除
     * @param idList
     * @return
     */
    public int deleteList(List<Integer> idList){
        int result = 0;
        int sum = 0;
        for (Integer id:idList){
            result = cardinfoMapper.delete(id);
            sum +=result;
        }
        return sum;
    }

    /**
     * 查询没有车卡的用户表的idno
     * @return
     */
    public List<String>queryIdno(){
        List<UserinfoEntity> userinfoEntities = userinfoMapper.queryAll();
        List<CardinfoEntity> cardinfoEntities = cardinfoMapper.queryAll();
        List<String> userIdnos = new ArrayList<>();
        List<String> cardIdnos = new ArrayList<>();
        for (UserinfoEntity userinfoEntity:userinfoEntities){
            userIdnos.add(userinfoEntity.getIdno());
        }
        for (CardinfoEntity cardinfoEntity:cardinfoEntities){
            cardIdnos.add(cardinfoEntity.getIdno());
        }
        userIdnos.removeAll(cardIdnos);
        return userIdnos;
    }
}
