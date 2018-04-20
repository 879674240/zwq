package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.service.ExperiLogService;
import com.xupt.service.dto.ExperiLogDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/query")
    public Response<List<ExperiLogDTO>> query(){
        Response<List<ExperiLogDTO>> response = new Response<>();
        List<ExperiLogDTO> experiLogDTOS = null;
        try {
            experiLogDTOS = experiLogService.queryLog();
            response.setCode(1);
            response.setData(experiLogDTOS);
            response.setMessage("查询日志成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询日志失败！");
        }
        return response;
    }
}
