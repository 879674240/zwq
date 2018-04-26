package com.xupt.webapp.controller;

import com.xupt.SyssetService;
import com.xupt.common.Response;
import com.xupt.dal.model.SyssetEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(value = "系统管理", description = "系统管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/sysset")
public class SyssetController {

    @Resource
    SyssetService syssetService;
    @ApiOperation(value = "获得系统设置列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<SyssetEntity> query(){
        Response<SyssetEntity> response = new Response<>();
        SyssetEntity syssetEntity = null;
        try {
            syssetEntity = syssetService.query();
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询异常！");
        }
        response.setCode(1);
        response.setData(syssetEntity);
        response.setMessage("查询成功！");
        return response;
    }
    @CrossOrigin("*")
    @ApiOperation(value = "编辑系统信息", notes = "编辑系统信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method=RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "系统信息",required = true) @RequestBody SyssetEntity syssetEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = syssetService.update(syssetEntity);
            response.setCode(1);
            response.setData(result);
            response.setMessage("编辑成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("编辑异常！");
        }
        return response;
    }
}
