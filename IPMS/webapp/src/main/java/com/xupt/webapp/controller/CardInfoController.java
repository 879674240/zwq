package com.xupt.webapp.controller;

import com.xupt.common.Response;
import com.xupt.dal.model.CardinfoEntity;
import com.xupt.dto.CardinfoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "cardinfo", description = "车卡管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/cardinfo")
public class CardInfoController {

    @ApiOperation(value = "获得卡信息列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<List<CardinfoEntity>> query(@ApiParam(value = "查询参数",required = true) @RequestBody CardinfoParam cardinfoParam){
        Response<List<CardinfoEntity>> response = new Response<>();
        return response;
    }

    @ApiOperation(value = "添加卡信息列表", notes = "添加信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "卡信息",required = true) @RequestBody CardinfoEntity cardinfoEntity){
        Response<Integer> response = new Response<>();
        return response;
    }

    @ApiOperation(value = "删除卡信息列表", notes = "删除信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "需要删除的id集合",required = true) @RequestBody List<Integer> idList){
        Response<Integer> response = new Response<>();
        return response;
    }

    @ApiOperation(value = "充值", notes = "充值", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "充值金额和id",required = true) @RequestBody CardinfoEntity cardinfoEntity){
        Response<Integer> response = new Response<>();
        return response;
    }
}
