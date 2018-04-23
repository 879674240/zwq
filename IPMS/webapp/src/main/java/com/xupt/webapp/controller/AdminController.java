package com.xupt.webapp.controller;

import com.xupt.AdminService;
import com.xupt.common.Response;
import com.xupt.dal.model.AdminEntity;
import com.xupt.dto.ListParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "管理员", description = "管理员管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @ApiOperation(value = "获得管理员列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<List<AdminEntity>> query(){
        Response<List<AdminEntity>> response = new Response<>();
        List<AdminEntity> adminEntities= null;
        try {
            adminEntities = adminService.query();
            response.setData(adminEntities);
            response.setCode(1);
            response.setMessage("返回管理员信息成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询管理员信息异常！");
        }
        return response;
    }
    @CrossOrigin("*")
    @ApiOperation(value = "添加管理员", notes = "添加管理员", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "管理员信息",required = true) @RequestBody AdminEntity adminEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = adminService.insert(adminEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该管理员员已经存在！");
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
    @ApiOperation(value = "修改管理员信息", notes = "修改信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method=RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "用户信息",required = true)@RequestBody AdminEntity adminEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = adminService.update(adminEntity);
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
    @ApiOperation(value = "删除管理员", notes = "删除信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "用户id",required = true)@RequestBody ListParam listParam){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = adminService.deleteList(listParam.getIdList());
            response.setCode(1);
            response.setMessage("删除成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("删除失败！");
        }
        return response;
    }
}
