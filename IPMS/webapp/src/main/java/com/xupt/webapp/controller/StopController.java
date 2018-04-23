package com.xupt.webapp.controller;

import com.xupt.common.Response;
import com.xupt.dal.model.AdminEntity;
import com.xupt.dal.model.StopEntity;
import com.xupt.dto.StopParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "停车管理", description = "停车管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/stop")
public class StopController {
    @CrossOrigin("*")
    @ApiOperation(value = "添加停车信息", notes = "添加停车信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "车辆停放信息",required = true) @RequestBody StopParam stopParam){
        Response<Integer> response = new Response<>();
        int result = 0;

        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "获取空位信息", notes = "获取空位信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<List<StopEntity>> query(){
        Response<List<StopEntity>> response = new Response<>();

        return response;
    }
}
