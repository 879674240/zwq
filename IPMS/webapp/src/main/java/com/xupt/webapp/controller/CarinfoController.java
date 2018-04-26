package com.xupt.webapp.controller;

import com.xupt.CarinfoService;
import com.xupt.common.PageResult;
import com.xupt.common.Response;
import com.xupt.dal.model.CarinfoEntity;
import com.xupt.dto.CarinfoParam;
import com.xupt.dto.ListParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "carinfo", description = "车辆信息管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/carinfo")
public class CarinfoController {
    @Resource
    CarinfoService carinfoService;

    @ApiOperation(value = "获得车辆信息列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<PageResult<List<CarinfoEntity>>> query(@ApiParam(value = "查询参数",required = true) @RequestBody CarinfoParam carinfoParam){
        Response<PageResult<List<CarinfoEntity>>> response = new Response<>();
        PageResult<List<CarinfoEntity>> pageResult = null;
        try {
            pageResult = carinfoService.query(carinfoParam);
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询异常！");
        }
        response.setCode(1);
        response.setData(pageResult);
        response.setMessage("查询成功！");
        return response;
    }

    @ApiOperation(value = "添加车辆信息列表", notes = "添加信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "车辆信息",required = true) @RequestBody CarinfoEntity carinfoEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = carinfoService.insert(carinfoEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该车牌号已存在！");
            }else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("添加成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("添加异常！");
        }
        return response;
    }

    @ApiOperation(value = "删除车辆信息列表", notes = "删除信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "需要删除的id集合",required = true) @RequestBody ListParam listParam){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            carinfoService.deleteList(listParam.getIdList());
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("删除异常！");
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("删除成功！");
        return response;
    }

}
