package com.xupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户信息查询参数")
public class UserinfoParam {

    /**
     * 姓名
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "姓名", required = true)
    private String username;

    /**
     * 手机号码
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String tel;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

