package com.xupt.webapp.controller;

import com.xupt.common.Response;
import com.xupt.dal.model.SyssetEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Api(value = "系统管理", description = "系统管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/sysset")
public class SyssetController {

    @ApiOperation(value = "获得系统设置列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<SyssetEntity> query(){
        Response<SyssetEntity> response = new Response<>();

        return response;
    }
    @CrossOrigin("*")
    @ApiOperation(value = "编辑系统信息", notes = "编辑系统信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method=RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "系统信息",required = true) @RequestBody SyssetEntity syssetEntity){
        Response<Integer> response = new Response<>();
        int result = 0;

        return response;
    }
}
