package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.component.Response;
import com.xupt.dal.model.LaboratoryAssetsEntity;
import com.xupt.service.LaboratoryAssetsService;
import com.xupt.service.dto.LaboratoryAssetsParam;
import com.xupt.service.dto.ListParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "laborator", description = "实验室资产管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value = "/api/laborator")
public class LaboratorController {

    @Resource
    LaboratoryAssetsService laboratoryAssetsService;
    /**
     * 录入实验室资产
     * @param laboratoryAssetsEntity
     * @return
     */
    @ApiOperation(value = "录入实验室资产", notes = "录入实验室资产", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "实验室资产",required = true) @RequestBody LaboratoryAssetsEntity laboratoryAssetsEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = laboratoryAssetsService.insert(laboratoryAssetsEntity);
            if(result==0){
                response.setCode(0);
                response.setMessage("该编号资产已经存在！");
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("插入实验室资产失败！");
                return response;
            }
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("插入实验室资产成功！");
        return response;
    }

    /**
     * 维护实验室资产
     * @param laboratoryAssetsEntity
     * @return
     */
    @ApiOperation(value = "修改资产信息", notes = "修改资产信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "实验室资产",required = true) @RequestBody LaboratoryAssetsEntity laboratoryAssetsEntity){

        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = laboratoryAssetsService.update(laboratoryAssetsEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("更新实验室资产失败！");
                return response;
            }
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("更新实验室资产成功！");
        return response;
    }

    /**
     * 查询实验室资产
     * @param laboratoryAssetsParam
     * @return
     */
    @ApiOperation(value = "查询实验室资产", notes = "查询实验室资产", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public Response<PageResult<List<LaboratoryAssetsEntity>>> query(@ApiParam(value = "实验室资产",required = true) @RequestBody LaboratoryAssetsParam laboratoryAssetsParam){
        Response<PageResult<List<LaboratoryAssetsEntity>>> response = new Response<>();
        PageResult<List<LaboratoryAssetsEntity>> pageResult = null;
        try {
            pageResult = laboratoryAssetsService.query(laboratoryAssetsParam);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("查询实验室资产信息失败！");
                return response;
            }
        }
        response.setCode(1);
        response.setData(pageResult);
        response.setMessage("查询实验室资产信息成功！");
        return response;

    }

    /**
     * 按id查询实验室资产，用于回显功能
     * @param id
     * @return
     */
    @ApiOperation(value = "按id查询", notes = "按id查询实验室资产，用于回显功能", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryById",method = RequestMethod.POST)
    public Response<LaboratoryAssetsEntity> queryById(Integer id){
        Response<LaboratoryAssetsEntity> response = new Response<>();
        LaboratoryAssetsEntity laboratoryAssetsEntity = null;
        try {
            laboratoryAssetsEntity = laboratoryAssetsService.queryById(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("查询实验室资产信息失败！");
                return response;
            }
        }
        response.setCode(1);
        response.setData(laboratoryAssetsEntity);
        response.setMessage("查询实验室资产信息成功！");
        return response;
    }

    /**
     * 删除实验室资产记录
     * @param listParam
     * @return
     */
    @ApiOperation(value = "删除实验室资产记录", notes = "删除实验室资产记录", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "实验室资产",required = true) @RequestBody ListParam listParam){

        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = laboratoryAssetsService.delete(listParam.getIdList());
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("删除实验室资产失败！");
                return response;
            }
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("删除实验室资产成功！");
        return response;
    }
}
