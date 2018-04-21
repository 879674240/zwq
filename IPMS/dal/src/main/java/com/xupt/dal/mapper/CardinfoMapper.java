package com.xupt.dal.mapper;

import com.xupt.dal.model.CardinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-21 18:48:07
 * @description: cardinfo()
 */
public interface CardinfoMapper {
    int insert(CardinfoEntity entity);
    int updateById(@Param("id") Integer id);
    CardinfoEntity getById(@Param("id") Integer id);
}
