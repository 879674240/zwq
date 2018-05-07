package com.xupt.service;

import com.xupt.component.BizException;
import com.xupt.dal.mapper.ExperimentalTaskMapper;
import com.xupt.dal.mapper.InnumMapper;
import com.xupt.dal.mapper.ScheduleMapper;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.dal.model.InnumEntity;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.dto.ExpeiLogParam;
import com.xupt.service.dto.ExperiLogDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public List<ExperiLogDTO> queryLog(ExpeiLogParam expeiLogParam) throws  BizException{
        List<ScheduleEntity> scheduleEntities = null;
        ExperimentalTaskEntity experimentalTaskEntity = null;
        InnumEntity innumEntity = null;
        List<ExperiLogDTO> experiLogDTOS = new ArrayList<>();
        ScheduleEntity scheduleEntitytemp = new ScheduleEntity();
        BeanUtils.copyProperties(expeiLogParam,scheduleEntitytemp);
        if(expeiLogParam.getWeekly()==0){
            scheduleEntitytemp.setWeekly(null);
        }
        if("".equals(expeiLogParam.getOperator())){
            scheduleEntitytemp.setOperator(null);
        }
        if("".equals(expeiLogParam.getRoom())){
            scheduleEntitytemp.setRoom(null);
        }
        try {
            scheduleEntities = scheduleMapper.queryAllOrder(scheduleEntitytemp);
            for (ScheduleEntity scheduleEntity:scheduleEntities) {
                ExperiLogDTO experiLogDTO = new ExperiLogDTO();
                experimentalTaskEntity = experimentalTaskMapper.queryByNum(scheduleEntity.getArrange());
                if(experimentalTaskEntity == null){
                    return null;
                }
                innumEntity = innumMapper.queryByKey(scheduleEntity.getRoom());
                if (innumEntity == null){
                    return null;
                }
                BeanUtils.copyProperties(experimentalTaskEntity,experiLogDTO);
                BeanUtils.copyProperties(scheduleEntity,experiLogDTO);
                experiLogDTO.setRoom(innumEntity.getValue());
                experiLogDTO.setWeekly(String.valueOf(scheduleEntity.getWeekly()+1));
                experiLogDTO.setTimeslot(String.valueOf(scheduleEntity.getWeek()%6));
                experiLogDTO.setCompulsoryElective(experiLogDTO.getCompulsoryElective());
                experiLogDTO.setWeekly("第"+experiLogDTO.getWeekly()+"周");
                Integer week = scheduleEntity.getWeek();
                if(week>0 && week <7){
                    experiLogDTO.setWeek(String.valueOf(1));
                }else if(week>6 && week <13){
                    experiLogDTO.setWeek(String.valueOf(2));
                }else if(week>12 && week <19){
                    experiLogDTO.setWeek(String.valueOf(3));
                }else if(week>18 && week <25){
                    experiLogDTO.setWeek(String.valueOf(4));
                }else if(week>24 && week <31){
                    experiLogDTO.setWeek(String.valueOf(5));
                }
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
                String dateString = "2014-09-01 08:00";
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = sf.parse(dateString);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DAY_OF_YEAR,1);

                experiLogDTOS.add(experiLogDTO);
            }
        }catch (Exception e){
            throw new BizException("查询数据库表异常");
        }
        return experiLogDTOS;
    }
}
