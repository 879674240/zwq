package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.ScheduleService;
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
    public Response<List<ScheduleEntity>> query(Integer room){
        Response<List<ScheduleEntity>> response = new Response<>();
        List<ScheduleEntity> scheduleEntities = null;
        try {
            scheduleEntities = scheduleService.queryByLabRoom(room);
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询实验安排数据失败！");
        }
        response.setCode(1);
        response.setData(scheduleEntities);
        response.setMessage("查询实验安排数据成功！");
        return response;
    }

    /**
     * 安排实验
     * @param scheduleEntity
     * @return
     */
    @RequestMapping(value = "insert")
    public Response<Integer> insert(ScheduleEntity scheduleEntity){
        return null;
    }

    /**
     * 更新实验
     * @param scheduleEntity
     * @return
     */
    @RequestMapping(value = "update")
    public Response<Integer> update(ScheduleEntity scheduleEntity){
        return null;
    }

    /**
     * 删除实验
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    public Response<Integer> delete(Integer id){
        return null;
    }
}
