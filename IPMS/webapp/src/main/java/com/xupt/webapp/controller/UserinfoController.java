package com.xupt.webapp.controller;

import com.xupt.UserinfoService;
import com.xupt.common.PageResult;
import com.xupt.common.Response;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.dto.ListParam;
import com.xupt.dto.UserinfoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "userinfo", description = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/userinfo")
public class UserinfoController {

    @Resource
    UserinfoService userinfoService;

    @ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<PageResult<List<UserinfoEntity>>> query(@ApiParam(value = "查询参数",required = true) @RequestBody UserinfoParam userinfoParam){
        Response<PageResult<List<UserinfoEntity>>> response = new Response<>();
        PageResult<List<UserinfoEntity>> pageResult = new PageResult<>();

        try {
            pageResult = userinfoService.query(userinfoParam);
            response.setData(pageResult);
            response.setCode(1);
            response.setMessage("查询用户信息成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询用户信息异常！");
        }
        return response;
    }
    @CrossOrigin("*")
    @ApiOperation(value = "添加用户", notes = "添加用户", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "操作员信息",required = true) @RequestBody UserinfoEntity userinfoEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = userinfoService.insert(userinfoEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该用户已经存在！");
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
    @ApiOperation(value = "修改用户信息", notes = "修改信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method=RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "用户信息",required = true)@RequestBody UserinfoEntity userinfoEntity){
        Response<Integer> response = new Response<>();
        int result = 0;

        try {
            result = userinfoService.update(userinfoEntity);
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
    @ApiOperation(value = "删除用户", notes = "删除信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "用户id",required = true)@RequestBody ListParam listParam){
        Response<Integer> response = new Response<>();
        int result = 0;

        try {
            result = userinfoService.deleteList(listParam.getIdList());
            response.setCode(1);
            response.setMessage("删除成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("删除异常！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "重置用户密码", notes = "修改信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePawd",method=RequestMethod.POST)
    public Response<Integer> updatePawd(@ApiParam(value = "用户信息",required = true) @RequestBody UserinfoEntity userinfoEntity){
        Response<Integer> response = new Response<>();
        int result = 0;

        try {
            result = userinfoService.updatePawd(userinfoEntity);
            if (result!=0){
                response.setCode(1);
                response.setData(result);
                response.setMessage("重置密码成功！");
            }else {
                response.setCode(0);
                response.setMessage("重置密码失败！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("重置密码异常！");
        }
        return response;
    }
}
