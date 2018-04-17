package com.xupt.dal.mapper;

import com.xupt.dal.model.ScheduleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-18 00:21:40
 * @description: schedule()
 */
public interface ScheduleMapper {
    int insert(ScheduleEntity entity);
    int updateById(@Param("id") Integer id);
    ScheduleEntity getById(@Param("id") Integer id);
}
