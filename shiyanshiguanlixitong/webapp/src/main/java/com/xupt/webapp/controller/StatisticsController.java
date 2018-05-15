package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.component.Response;
import com.xupt.dal.dto.ExperimentalTaskDTO;
import com.xupt.service.StatisticsService;
import com.xupt.service.dto.ExperimentalTaskParam;
import com.xupt.service.dto.NumParam;
import com.xupt.dal.dto.StatisticsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "statistics", description = "实验数据统计", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value = "/api/statistics")
public class StatisticsController {

    @Resource
    StatisticsService statisticsService;

    /**
     * 查询实验数据
     * @param experimentalTaskParam
     * @return
     */
    @ApiOperation(value = "查询实验数据", notes = "查询实验数据", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<PageResult<List<StatisticsDTO>>> query(@ApiParam(value = "实验编码",required = true) @RequestBody ExperimentalTaskParam experimentalTaskParam){
        Response<PageResult<List<StatisticsDTO>>> response = new Response<>();
        PageResult<List<StatisticsDTO>> pageResult = null;
        try {
                pageResult = statisticsService.query(experimentalTaskParam);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("查询实验数据信息失败！");
                return response;
            }
        }
        response.setCode(1);
        response.setData(pageResult);
        response.setMessage("查询实验数据信息成功！");
        return response;

    }

}
