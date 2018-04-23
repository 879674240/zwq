package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 17:23:33
 * @description: parking()
 */
public class ParkingEntity {
    /**
     * id
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 车位编号
     * not-null:true
     * default:''
     */
    private String position;

    /**
     * 状态
     * not-null:true
     * default:'0'
     */
    private Integer status;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

}
