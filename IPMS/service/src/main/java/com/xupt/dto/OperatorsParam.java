package com.xupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("operatorsParam")
public class OperatorsParam {

    /**
     * 姓名
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    /**
     * 手机号码
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String phonenum;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", required = true)
    private Integer currentPage;

    /**
     * 页大小
     */
    @ApiModelProperty(value = "页大小", required = true)
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
