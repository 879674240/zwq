package com.xupt.dal.mapper;

import com.xupt.dal.model.StopEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 17:11:53
 * @description: stop()
 */
public interface StopMapper {
    int insert(StopEntity entity);
    StopEntity queryByCardno(@Param("cardno")String cardno);
    int updateById(@Param("id") Integer id);
    StopEntity getById(@Param("id") Integer id);
    int deleteByCarnum(@Param("carnum")String carnum);
    StopEntity queryByCarnum(@Param("carnum")String carnum);
}
