package com.xupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "卡信息查询参数")
public class CardinfoParam {
    /**
     * 卡号
     */
    @ApiModelProperty(value = "卡号", required = true)
    private String cardno;
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

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
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
