package com.xupt.dal.dto;

public class UserinfoDTO {
    /**
     * 姓名
     */
    private String username;
    /**
     * 电话号
     */
    private String tel;
    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 每页大小
     */
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

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
