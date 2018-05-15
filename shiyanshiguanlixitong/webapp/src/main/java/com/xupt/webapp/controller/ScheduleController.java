package com.xupt.webapp.controller;

import com.xupt.component.HttpStatus;
import com.xupt.component.Response;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.ScheduleService;
import com.xupt.service.dto.ScheduleDTO;
import com.xupt.service.dto.ScheduleRoomDTO;
import com.xupt.service.dto.TableDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {
    @Resource
    ScheduleService scheduleService;
    @Resource
    JedisPool jedisPool;
    /**
     * 实验室房间号来查看课程安排
     * @param room
     * @return
     */
    @ApiOperation(value = "实验室房间号来查看课程安排", notes = "实验室房间号来查看课程安排", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<List<ScheduleDTO>> query(@ApiParam(value = "实验室房间号",required = true) @RequestBody String room){
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
    @ApiOperation(value = "安排实验", notes = "安排实验", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/arrange",method = RequestMethod.POST)
    public Response<Integer> arrange(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @ApiParam(value = "实验安排模型",required = true) @RequestBody ScheduleEntity scheduleEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            String authorization = httpServletRequest.getHeader("Authorization");
            if(authorization==null){
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
                response.setCode(0);
                response.setMessage("未授权！");
                return response;
            }
            Jedis jedis = jedisPool.getResource();
            String temp = jedis.get(authorization);
            jedis.close();
            if(temp==null){
                response.setCode(0);
                response.setMessage("未授权！");
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
                return response;
            }
            scheduleEntity.setOperator(temp);
            result = scheduleService.arrange(scheduleEntity);
            if(result==0){
                response.setCode(1);
                response.setMessage("该时间段已有课程安排！");
            }else if(result==2){
                response.setCode(1);
                response.setMessage("删除成功！");
            }
            else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("插入实验安排数据成功！");
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

    @ApiOperation(value = "实验室房间号来查看课程安排", notes = "实验室房间号来查看课程安排", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    public List<TableDTO> queryAll(@ApiParam(value = "教室编号",required = true) @RequestBody ScheduleRoomDTO scheduleRoomDTO){
        List<TableDTO> tableDTOS = null;
        try {
            tableDTOS = scheduleService.query(scheduleRoomDTO.getRoom());
        }catch (Exception e){
            e.printStackTrace();
        }
        return tableDTOS;
    }
    @ApiOperation(value = "初始化课表", notes = "初始化课表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryEmpty",method = RequestMethod.POST)
    public List<TableDTO> queryEmpty(){
        List<TableDTO> tableDTOS = null;
        try {
            tableDTOS = scheduleService.queryEmpty();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tableDTOS;
    }

}
