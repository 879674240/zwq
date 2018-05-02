package com.xupt.dal.mapper;

import com.xupt.dal.dto.CardinfoDTO;
import com.xupt.dal.model.CardinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 15:06:56
 * @description: cardinfo()
 */
public interface CardinfoMapper {
    int insert(CardinfoEntity entity);
    List<CardinfoEntity> query(CardinfoDTO cardinfoDTO);
    CardinfoEntity queryByCardno(@Param("cardno")String cardno);
    CardinfoEntity queryById(@Param("id")Integer id);
    int count(CardinfoDTO cardinfoDTO);
    int update(CardinfoEntity cardinfoEntity);
    int delete(@Param("id")Integer id);
    List<CardinfoEntity> queryAll();
    CardinfoEntity queryByIdno(@Param("idno")String idno);
}
