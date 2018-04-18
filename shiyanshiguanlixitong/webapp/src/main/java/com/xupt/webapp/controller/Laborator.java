package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.dal.model.LaboratoryAssetsEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/laborator")
public class Laborator {
    /**
     * 录入实验室资产
     * @param laboratoryAssetsEntity
     * @return
     */
    @RequestMapping(value = "/insert")
    public Response<Integer> laborator(LaboratoryAssetsEntity laboratoryAssetsEntity){
        return null;
    }

    /**
     * 维护实验室资产
     * @param laboratoryAssetsEntity
     * @return
     */
    @RequestMapping(value = "/update")
    public Response<Integer> update(LaboratoryAssetsEntity laboratoryAssetsEntity){
        return null;
    }

    /**
     * 查询实验室资产
     * @param laboratoryAssetsEntity
     * @return
     */
    @RequestMapping(value = "/query")
    public Response<List<LaboratoryAssetsEntity>> query(LaboratoryAssetsEntity laboratoryAssetsEntity){
        return null;
    }

    /**
     * 按id查询实验室资产，用于回显功能
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryById")
    public Response<LaboratoryAssetsEntity> queryById(Integer id){
        return null;
    }

    /**
     * 删除实验室资产记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public Response<Integer> delete(Integer id){
        return null;
    }
}
