package com.xupt.dal.mapper;

import com.xupt.dal.dto.CarinfoDTO;
import com.xupt.dal.model.CarinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 15:13:49
 * @description: carinfo()
 */
public interface CarinfoMapper {
    int insert(CarinfoEntity entity);
    List<CarinfoEntity> query(CarinfoDTO carinfoDTO);
    CarinfoEntity queryByIdno(@Param("idno")String idno);
    int count(CarinfoDTO carinfoDTO);
    int update(CarinfoEntity carinfoEntity);
    int delete(@Param("id") Integer id);
}
