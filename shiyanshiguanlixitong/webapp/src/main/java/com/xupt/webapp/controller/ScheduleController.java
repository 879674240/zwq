package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.ScheduleService;
import com.xupt.service.dto.ScheduleDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin("*")
    @ApiOperation(value = "实验室房间号来查看课程安排", notes = "实验室房间号来查看课程安排", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<List<ScheduleDTO>> query(@ApiParam(value = "实验室房间号",required = true) @RequestBody Integer room){
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
    @CrossOrigin("*")
    @ApiOperation(value = "安排实验", notes = "安排实验", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "实验安排模型",required = true) @RequestBody ScheduleEntity scheduleEntity){
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
    @CrossOrigin("*")
    @ApiOperation(value = "删除实验", notes = "删除实验", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "所删除id集合",required = true) @RequestBody Integer id){

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
