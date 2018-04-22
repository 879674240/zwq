package com.xupt.dal.mapper;

import com.xupt.dal.model.CardinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-22 23:56:47
 * @description: cardinfo()
 */
public interface CardinfoMapper {
    int insert(CardinfoEntity entity);
    int updateById(@Param("id") Integer id);
    CardinfoEntity getById(@Param("id") Integer id);
}
