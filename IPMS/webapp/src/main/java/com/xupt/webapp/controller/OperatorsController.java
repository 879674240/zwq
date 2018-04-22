package com.xupt.webapp.controller;

import com.xupt.OperatorsService;
import com.xupt.common.PageResult;
import com.xupt.common.Response;
import com.xupt.dal.model.OperatorsEntity;
import com.xupt.dto.OperatorsParam;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "operators", description = "操作员管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/operators")
public class OperatorsController {
    @Resource
    OperatorsService operatorsService;
    @ApiOperation(value = "获得操作员列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<PageResult<List<OperatorsEntity>>> query(@ApiParam(value = "查询参数",required = true) @RequestBody OperatorsParam operatorsParam){
        Response<PageResult<List<OperatorsEntity>>> response = new Response<>();
        PageResult<List<OperatorsEntity>> pageResult = new PageResult<>();
        try {
            pageResult = operatorsService.query(operatorsParam);
            response.setData(pageResult);
            response.setCode(1);
            response.setMessage("返回操作人员信息成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询操作人员信息异常！");
        }

        return response;
    }
    @CrossOrigin("*")
    @ApiOperation(value = "添加操作员", notes = "添加信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "insert",method=RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "操作员信息",required = true) @RequestBody OperatorsEntity operatorsEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = operatorsService.insert(operatorsEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该操作人员已经存在！");
            }else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("添加成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("添加失败！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "修改操作员信息", notes = "修改信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "update",method=RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "操作员信息",required = true)@RequestBody OperatorsEntity operatorsEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = operatorsService.update(operatorsEntity);
            response.setCode(1);
            response.setData(result);
            response.setMessage("修改成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("修改失败！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "删除操作员", notes = "删除信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "delete",method=RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "操作员id",required = true)@RequestBody List<Integer> idList){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = operatorsService.deleteList(idList);
            response.setCode(1);
            response.setMessage("删除成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("删除失败！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "重置操作员密码", notes = "修改信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "updatePawd",method=RequestMethod.POST)
    public Response<Integer> updatePawd(@ApiParam(value = "操作员信息",required = true) @RequestBody OperatorsEntity operatorsEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = operatorsService.updatePawd(operatorsEntity);
            response.setCode(1);
            response.setData(result);
            response.setMessage("重置密码成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("重置密码失败！");
        }
        return response;
    }
}
