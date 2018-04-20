package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.ScheduleService;
import com.xupt.service.dto.ScheduleDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {
    @Resource
    ScheduleService scheduleService;
    /**
     * 实验室房间号来查看课程安排
     * @param room
     * @return
     */
    @RequestMapping(value = "query")
    public Response<List<ScheduleDTO>> query(Integer room){
        Response<List<ScheduleDTO>> response = new Response<>();
        List<ScheduleDTO> scheduleDTOS = null;
        try {
            scheduleDTOS = scheduleService.queryByLabRoom(room);
            response.setCode(1);
            response.setData(scheduleDTOS);
            response.setMessage("查询实验安排数据成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询实验安排数据失败！");
        }
        return response;
    }

    /**
     * 安排实验
     * @param scheduleEntity
     * @return
     */
    @RequestMapping(value = "insert")
    public Response<Integer> insert(ScheduleEntity scheduleEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = scheduleService.insert(scheduleEntity);
            if(result!=0){
                response.setCode(1);
                response.setData(result);
                response.setMessage("插入实验安排数据成功！");
            }else{
                response.setMessage("还是时间段已有课程安排！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("插入实验安排数据失败！");
        }

        return response;
    }


    /**
     * 删除实验
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    public Response<Integer> delete(Integer id){

        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = scheduleService.delete(id);
            response.setCode(1);
            response.setData(result);
            response.setMessage("删除实验安排数据成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("删除实验安排数据失败！");
        }
        return response;
    }
}
