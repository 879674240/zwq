package com.xupt.dal.mapper;

import com.xupt.dal.model.ParkingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 17:23:33
 * @description: parking()
 */
public interface ParkingMapper {
    int insert(ParkingEntity entity);
    List<ParkingEntity> query();
    int updateByPosi(ParkingEntity parkingEntity);
    ParkingEntity getById(@Param("id") Integer id);
}
