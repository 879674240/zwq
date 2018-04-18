package com.xupt.service;

import com.xupt.component.BizException;
import com.xupt.dal.mapper.ScheduleMapper;
import com.xupt.dal.model.ScheduleEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleService {
    @Resource
    ScheduleMapper scheduleMapper;

    /**
     * 查询排课计划
     * @param room
     * @return
     * @throws BizException
     */
    public List<ScheduleEntity> queryByLabRoom(Integer room) throws BizException{
        List<ScheduleEntity> scheduleEntities = null;
        try {
            scheduleEntities = scheduleMapper.queryByLabRoom(room);
        }catch (Exception e){
            throw new BizException("查询排课计划异常！");
        }
        return scheduleEntities;
    }

    /**
     * 插入排课计划
     * @param scheduleEntity
     * @return
     * @throws BizException
     */
    public Integer insert(ScheduleEntity scheduleEntity) throws BizException{
        int result;
        ScheduleEntity scheduleEntity1;
        try {
            scheduleEntity1 = scheduleMapper.queryByTime(scheduleEntity.getWeekly(),scheduleEntity.getWeek(),
                    scheduleEntity.getTimeslot(),scheduleEntity.getRoom());
            if (scheduleEntity1!=null){
                return 0;
            }
            result = scheduleMapper.insert(scheduleEntity);
        }catch (Exception e){
            throw new BizException("插入排课计划异常！");
        }
        return result;
    }

    /**
     * 删除排课计划
     * @param id
     * @return
     * @throws BizException
     */
    public Integer delete(Integer id) throws BizException{
        int result;
        try {
            result = scheduleMapper.delete(id);
        }catch (Exception e){
            throw new BizException("删除排课计划异常！");
        }
        return result;
    }
}
