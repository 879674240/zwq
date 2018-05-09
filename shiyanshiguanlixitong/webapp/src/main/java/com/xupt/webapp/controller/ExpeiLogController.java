package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.dal.model.ScheduleEntity;
import com.xupt.service.ExperiLogService;
import com.xupt.service.dto.ExpeiLogParam;
import com.xupt.service.dto.ExperiLogDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实验日志生成
 */
@RestController
@RequestMapping(value = "/api/experiLog")
public class ExpeiLogController {
    @Resource
    ExperiLogService experiLogService;

    @CrossOrigin("*")
    @ApiOperation(value = "查询实验日志", notes = "查询实验日志", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<List<ExperiLogDTO>> query(@ApiParam(value = "日志查询条件",required = true) @RequestBody ExpeiLogParam expeiLogParam){
        Response<List<ExperiLogDTO>> response = new Response<>();
        List<ExperiLogDTO> experiLogDTOS = null;
        if(expeiLogParam.getWeekly()!=null){
            if(expeiLogParam.getWeekly()<1 || expeiLogParam.getWeekly()>18){
                response.setCode(0);
                response.setMessage("请输入1-18周的周次！");
                return response;
            }
        }
        try {
            experiLogDTOS = experiLogService.queryLog(expeiLogParam);
            if (experiLogDTOS==null){
                response.setCode(1);
                response.setMessage("没有查询到相关日志！");
            }else{
                response.setCode(1);
                response.setData(experiLogDTOS);
                response.setMessage("查询日志成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询日志失败！");
        }
        return response;
    }
}
