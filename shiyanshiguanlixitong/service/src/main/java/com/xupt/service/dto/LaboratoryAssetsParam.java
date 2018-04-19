package com.xupt.service.dto;

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
    private String num;

    /**
     * 资产名称
     * not-null:true
     * default:''
     */
    private String name;

    /**
     * 状态
     * not-null:true
     * default:''
     */
    private String status;

    /**
     * 所属实验室
     * not-null:true
     * default:''
     */
    private String belong;

    /**
     * 负责人
     * not-null:true
     * default:''
     */
    private String personInCharge;

    /**
     * 备注
     * not-null:true
     * default:''
     */
    private String remark;
    /**
     * 当前页
     * not-null:true
     * default:'0'
     */
    private int currentPage;

    /**
     * 页面大小
     * not-null:true
     * default:'0'
     */
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
