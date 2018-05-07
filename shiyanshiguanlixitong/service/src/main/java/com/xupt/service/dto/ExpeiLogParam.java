package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: lenovo
 * @time: 2018-04-18 00:21:40
 * @description: schedule()
 */
@ApiModel(value = "日志查询条件", description = "user2")
public class ExpeiLogParam {

    /**
     * 周次
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "周次", required = true)
    private Integer weekly;

    /**
     * 操作人
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "操作", required = true)
    private String operator;

    /**
     * 实验室房间号
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "实验室房间号", required = true)
    private String room;

    public Integer getWeekly() {
        return weekly;
    }

    public void setWeekly(Integer weekly) {
        this.weekly = weekly;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}