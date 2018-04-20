package com.xupt.service;

import com.xupt.component.BizException;
import com.xupt.dal.mapper.ExperimentalTaskMapper;
import com.xupt.dal.mapper.InnumMapper;
import com.xupt.dal.mapper.ScheduleMapper;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.dal.model.InnumEntity;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.dto.ExperiLogDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看实验日志
 */
@Service
public class ExperiLogService {
    @Resource
    ScheduleMapper scheduleMapper;
    @Resource
    ExperimentalTaskMapper experimentalTaskMapper;
    @Resource
    InnumMapper innumMapper;

    public List<ExperiLogDTO> queryLog() throws  BizException{
        List<ScheduleEntity> scheduleEntities = null;
        ExperimentalTaskEntity experimentalTaskEntity = null;
        InnumEntity innumEntity = null;
        List<ExperiLogDTO> experiLogDTOS = new ArrayList<>();
        try {
            scheduleEntities = scheduleMapper.queryAll();
            for (ScheduleEntity scheduleEntity:scheduleEntities) {
                ExperiLogDTO experiLogDTO = new ExperiLogDTO();
                experimentalTaskEntity = experimentalTaskMapper.queryByNum(scheduleEntity.getArrange());
                innumEntity = innumMapper.queryByKey(scheduleEntity.getRoom());
                BeanUtils.copyProperties(experimentalTaskEntity,experiLogDTO);
                BeanUtils.copyProperties(scheduleEntity,experiLogDTO);
                experiLogDTO.setRoom(innumEntity.getValue());
                experiLogDTO.setWeekly(String.valueOf(scheduleEntity.getWeekly()));
                experiLogDTO.setWeek(String.valueOf(scheduleEntity.getWeek()));
                experiLogDTO.setTimeslot(String.valueOf(scheduleEntity.getTimeslot()));
                experiLogDTO.setCompulsoryElective(String.valueOf(experiLogDTO.getCompulsoryElective()));
                experiLogDTO.setWeekly("第"+experiLogDTO.getWeekly()+"周");
                switch(experiLogDTO.getWeek()){
                    case "1":
                        experiLogDTO.setWeek("星期一");break;
                    case "2":
                        experiLogDTO.setWeek("星期二");break;
                    case "3":
                        experiLogDTO.setWeek("星期三");break;
                    case "4":
                        experiLogDTO.setWeek("星期四");break;
                    case "5":
                        experiLogDTO.setWeek("星期五");break;
                    case "6":
                        experiLogDTO.setWeek("星期六");break;
                    default:
                        experiLogDTO.setWeek("星期天");break;
                }
                switch(experiLogDTO.getTimeslot()){
                    case "1":
                        experiLogDTO.setTimeslot("1-2");break;
                    case "2":
                        experiLogDTO.setTimeslot("3-4");break;
                    case "3":
                        experiLogDTO.setTimeslot("中午");break;
                    case "4":
                        experiLogDTO.setTimeslot("5-6");break;
                    case "5":
                        experiLogDTO.setTimeslot("7-8");break;
                    default:
                        experiLogDTO.setTimeslot("晚上");break;
                }
                switch(experiLogDTO.getCompulsoryElective()){
                    case "0":
                        experiLogDTO.setTimeslot("必修");break;
                    default:
                        experiLogDTO.setTimeslot("选修");break;
                }

                experiLogDTOS.add(experiLogDTO);
            }
        }catch (Exception e){
            throw new BizException("查询数据库表异常");
        }
        return experiLogDTOS;
    }
}
