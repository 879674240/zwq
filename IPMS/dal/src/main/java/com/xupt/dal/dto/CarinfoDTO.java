package com.xupt.dal.dto;

public class CarinfoDTO {
    /**
     * 车牌号
     */
    private String carnum;
    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 每页大小
     */
    private Integer pageSize;

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
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
