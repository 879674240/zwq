package com.xupt.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xupt.component.BizException;
import com.xupt.dal.mapper.ExperimentalTaskMapper;
import com.xupt.dal.mapper.InnumMapper;
import com.xupt.dal.mapper.ScheduleMapper;
import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.dal.model.InnumEntity;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.Tool.Template;
import com.xupt.service.dto.ScheduleDTO;
import com.xupt.service.dto.TableDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Resource
    ScheduleMapper scheduleMapper;
    @Resource
    ExperimentalTaskMapper experimentalTaskMapper;
    @Resource
    InnumMapper innumMapper;
    @Resource
    UserinfoMapper userinfoMapper;
    /**
     * 查询排课计划
     * @param room
     * @return
     * @throws BizException
     */
    public List<ScheduleDTO> queryByLabRoom(String room) throws BizException{
        List<ScheduleEntity> scheduleEntities = null;
        ExperimentalTaskEntity experimentalTaskEntity;
        InnumEntity innumEntity;
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        try {
            scheduleEntities = scheduleMapper.queryByLabRoom(room);
            for (ScheduleEntity scheduleEntity:scheduleEntities) {
                ScheduleDTO scheduleDTO = new ScheduleDTO();
                experimentalTaskEntity = experimentalTaskMapper.queryByNum(scheduleEntity.getArrange());
                innumEntity = innumMapper.queryByKey(scheduleEntity.getRoom());
                BeanUtils.copyProperties(experimentalTaskEntity,scheduleDTO);
                BeanUtils.copyProperties(scheduleEntity,scheduleDTO);
                scheduleDTO.setRoom(innumEntity.getValue());
                scheduleDTOS.add(scheduleDTO);
            }
        }catch (Exception e){
            throw new BizException("查询排课计划异常！");
        }
        return scheduleDTOS;
    }

    /**
     * 插入排课计划
     * @param scheduleEntity
     * @return
     * @throws BizException
     */
    public Integer arrange(ScheduleEntity scheduleEntity) throws BizException{
        int result;
        ScheduleEntity scheduleEntity1;
        try {
            scheduleEntity1 = scheduleMapper.queryByTime(scheduleEntity.getWeekly(),scheduleEntity.getWeek(),
                    0,scheduleEntity.getRoom());
            UserinfoEntity userinfoEntity = userinfoMapper.queryByName(scheduleEntity.getOperator());
            if (scheduleEntity1!=null){
                /**
                 * 若编号相同，则删除
                 */
                if(scheduleEntity1.getArrange().equals(scheduleEntity.getArrange())){
                    if(scheduleEntity1.getOperator().equals(userinfoEntity.getRealname())){
                        scheduleMapper.deleteBytime(scheduleEntity);
                        return 2;
                    }
                    return 3;
                }else{
                    return 0;
                }
            }else{
                scheduleEntity.setOperator(userinfoEntity.getRealname());
                result = scheduleMapper.insert(scheduleEntity);
            }
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

    /**
     * 将数据库中对应课程放入排课表
     * @param room
     * @return
     */
    public List<TableDTO> query(String room){
        JSONArray jsonArray = JSONArray.parseArray(Template.getTemplate());
        List<TableDTO> tableDTOS = jsonArray.toJavaList(TableDTO.class);
        if(jsonArray.size()>0){
            for(int i=0;i<jsonArray.size();i++){
                JSONObject job = jsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println(job.get("name")+"=") ;  // 得到 每个对象中的属性值
            }
        }
        List<ScheduleEntity> scheduleEntities = scheduleMapper.queryByLabRoom(room);
        if(scheduleEntities==null){
            return null;
        }
        for(ScheduleEntity scheduleEntity:scheduleEntities){
            int weekly = scheduleEntity.getWeekly();
            int week = scheduleEntity.getWeek();
            String number = scheduleEntity.getArrange();
            TableDTO tableDTO = tableDTOS.get(weekly);
            switch(String.valueOf(week)){
                case "1":
                    tableDTO.setFirstclass1(number);break;
                case "2":
                    tableDTO.setSecondclass1(number);break;
                case "3":
                    tableDTO.setNoon1(number);break;
                case "4":
                    tableDTO.setThirdclass1(number);break;
                case "5":
                    tableDTO.setFourthclass1(number);break;
                case "6":
                    tableDTO.setNight1(number);break;
                case "7":
                    tableDTO.setFirstclass2(number);break;
                case "8":
                    tableDTO.setSecondclass2(number);break;
                case "9":
                    tableDTO.setNoon2(number);break;
                case "10":
                    tableDTO.setThirdclass2(number);break;
                case "11":
                    tableDTO.setFourthclass2(number);break;
                case "12":
                    tableDTO.setNight2(number);break;
                case "13":
                    tableDTO.setFirstclass3(number);break;
                case "14":
                    tableDTO.setSecondclass3(number);break;
                case "15":
                    tableDTO.setNoon3(number);break;
                case "16":
                    tableDTO.setThirdclass3(number);break;
                case "17":
                    tableDTO.setFourthclass3(number);break;
                case "18":
                    tableDTO.setNight3(number);break;
                case "19":
                    tableDTO.setFirstclass4(number);break;
                case "20":
                    tableDTO.setSecondclass4(number);break;
                case "21":
                    tableDTO.setNoon4(number);break;
                case "22":
                    tableDTO.setThirdclass4(number);break;
                case "23":
                    tableDTO.setFourthclass4(number);break;
                case "24":
                    tableDTO.setNight4(number);break;
                case "25":
                    tableDTO.setFirstclass5(number);break;
                case "26":
                    tableDTO.setSecondclass5(number);break;
                case "27":
                    tableDTO.setNoon5(number);break;
                case "28":
                    tableDTO.setThirdclass5(number);break;
                case "29":
                    tableDTO.setFourthclass5(number);break;
                default:
                    tableDTO.setNight5(number);break;
            }
        }
        return tableDTOS;
    }

    /**
     * 初始化排课表
     * @return
     */
    public List<TableDTO> queryEmpty(){
        JSONArray jsonArray = JSONArray.parseArray(Template.getTemplate());
        List<TableDTO> tableDTOS = jsonArray.toJavaList(TableDTO.class);
        return tableDTOS;
    }
}
