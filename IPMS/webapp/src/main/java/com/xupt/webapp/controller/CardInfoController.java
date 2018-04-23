package com.xupt.webapp.controller;

import com.xupt.common.PageResult;
import com.xupt.common.Response;
import com.xupt.dal.model.CardinfoEntity;
import com.xupt.dto.CardinfoParam;
import com.xupt.CardinfoService;
import com.xupt.dto.ListParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "cardinfo", description = "车卡管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/cardinfo")
public class CardInfoController {

    @Resource
    CardinfoService cardinfoService;

    @ApiOperation(value = "获得卡信息列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<PageResult<List<CardinfoEntity>>> query(@ApiParam(value = "查询参数",required = true) @RequestBody CardinfoParam cardinfoParam){
        Response<PageResult<List<CardinfoEntity>>> response = new Response<>();
        PageResult<List<CardinfoEntity>> pageResult = null;
        try {
            pageResult = cardinfoService.query(cardinfoParam);
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询异常！");
        }
        response.setCode(1);
        response.setData(pageResult);
        response.setMessage("查询成功！");
        return response;
    }

    @ApiOperation(value = "添加卡信息列表", notes = "添加信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "卡信息",required = true) @RequestBody CardinfoEntity cardinfoEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = cardinfoService.insert(cardinfoEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该卡号已存在！");
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

    @ApiOperation(value = "删除卡信息列表", notes = "删除信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "需要删除的id集合",required = true) @RequestBody ListParam listParam){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            cardinfoService.deleteList(listParam.getIdList());
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("删除异常！");
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("删除成功！");
        return response;
    }

    @ApiOperation(value = "充值", notes = "充值", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "充值金额和id",required = true) @RequestBody CardinfoEntity cardinfoEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            cardinfoService.update(cardinfoEntity);
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("充值异常！");
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("充值成功！");
        return response;
    }
}
