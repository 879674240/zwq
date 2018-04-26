package com.xupt;

import com.xupt.dal.mapper.ParkingMapper;
import com.xupt.dal.mapper.StopMapper;
import com.xupt.dal.model.ParkingEntity;
import com.xupt.dal.model.StopEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StopService {
    @Resource
    StopMapper stopMapper;
    @Resource
    ParkingMapper parkingMapper;

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
        return result;
    }

    public List<ParkingEntity> queryPark(){
        List<ParkingEntity> parkingEntities = parkingMapper.query();
        return parkingEntities;
    }
}
