package com.xupt.dal.mapper;

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
    int updateById(@Param("id") Integer id);
    CarinfoEntity getById(@Param("id") Integer id);
}
