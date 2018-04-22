package com.xupt.dto;

import io.swagger.annotations.ApiModelProperty;

public class CardinfoParam {
    /**
     * 卡号
     */
    @ApiModelProperty(value = "卡号", required = true)
    private String idno;
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

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
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
