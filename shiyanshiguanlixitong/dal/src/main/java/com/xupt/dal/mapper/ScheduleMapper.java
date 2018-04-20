package com.xupt.dal.mapper;

import com.xupt.dal.model.ScheduleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-18 00:21:40
 * @description: schedule()
 */
@Repository
public interface ScheduleMapper {
    int insert(ScheduleEntity entity);
    int update(ScheduleEntity entity);
    int delete(@Param("id")Integer id);
    List<ScheduleEntity> queryByLabRoom(@Param("room") Integer room);
    List<ScheduleEntity> queryAll();
    ScheduleEntity queryByTime(@Param("weekly")Integer weekly,@Param("week")Integer week,
                               @Param("timeSlot")Integer timeSlot,@Param("room")String room);
}
