package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "实验室资产查询参数", description = "task")
public class LaboratoryAssetsParam {

    /**
     * id
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 资产编号
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "资产编号", required = true)
    private String num;

    /**
     * 资产名称
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "资产名称", required = true)
    private String name;

    /**
     * 状态
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "状态", required = true)
    private String status;

    /**
     * 所属实验室
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "所属实验室", required = true)
    private String belong;

    /**
     * 负责人
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "负责人", required = true)
    private String personInCharge;

    /**
     * 备注
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "备注", required = true)
    private String remark;
    /**
     * 当前页
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "当前页", required = true)
    private int currentPage;

    /**
     * 页面大小
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "页面大小", required = true)
    private int pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
