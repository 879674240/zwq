package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.component.Response;
import com.xupt.dal.model.LaboratoryAssetsEntity;
import com.xupt.service.LaboratoryAssetsService;
import com.xupt.service.dto.LaboratoryAssetsParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @RequestMapping(value = "/insert")
    public Response<Integer> laborator(LaboratoryAssetsEntity laboratoryAssetsEntity){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        int result = 0;
        try {
            result = laboratoryAssetsService.insert(laboratoryAssetsEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("插入实验室资产失败！");
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
    @RequestMapping(value = "/update")
    public Response<Integer> update(LaboratoryAssetsEntity laboratoryAssetsEntity){

        Response<Integer> response = new Response<>();
        response.setCode(0);
        int result = 0;
        try {
            result = laboratoryAssetsService.update(laboratoryAssetsEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("更新实验室资产失败！");
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
    @RequestMapping(value = "/query")
    public Response<PageResult<List<LaboratoryAssetsEntity>>> query(LaboratoryAssetsParam laboratoryAssetsParam){
        Response<PageResult<List<LaboratoryAssetsEntity>>> response = new Response<>();
        response.setCode(0);
        PageResult<List<LaboratoryAssetsEntity>> pageResult = null;
        try {
            pageResult = laboratoryAssetsService.query(laboratoryAssetsParam);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("查询实验室资产信息失败！");
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
    @RequestMapping(value = "/queryById")
    public Response<LaboratoryAssetsEntity> queryById(Integer id){
        Response<LaboratoryAssetsEntity> response = new Response<>();
        response.setCode(0);
        LaboratoryAssetsEntity laboratoryAssetsEntity = null;
        try {
            laboratoryAssetsEntity = laboratoryAssetsService.queryById(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("查询实验室资产信息失败！");
            }
        }
        response.setCode(1);
        response.setData(laboratoryAssetsEntity);
        response.setMessage("查询实验室资产信息成功！");
        return response;
    }

    /**
     * 删除实验室资产记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public Response<Integer> delete(Integer id){

        Response<Integer> response = new Response<>();
        response.setCode(0);
        int result = 0;
        try {
            result = laboratoryAssetsService.delete(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("删除实验室资产失败！");
            }
        }
        response.setCode(1);
        response.setData(result);
        response.setMessage("删除实验室资产成功！");
        return response;
    }
}
