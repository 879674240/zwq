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
}
