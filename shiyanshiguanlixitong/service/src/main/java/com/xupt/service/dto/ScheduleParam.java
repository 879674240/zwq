package com.xupt.service.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: lenovo
 * @time: 2018-04-18 00:21:40
 * @description: schedule()
 */
@ApiModel(value = "排课计划", description = "user2")
public class ScheduleParam {
    /**
     *
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 周次
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "周次", required = true)
    private Integer weekly;

    /**
     * 星期
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "星期", required = true)
    private Integer week;

    /**
     * 时间段
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "时间段", required = true)
    private Integer timeslot;

    /**
     * 任务安排
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "任务安排", required = true)
    private String arrange;

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

    /**
     * 备注
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "备注", required = true)
    private String remark;

    /**
     * 预留1
     * not-null:true
     * default:''
     */
    private String reserve1;

    /**
     * 预留2
     * not-null:true
     * default:''
     */
    private String reserve2;

    /**
     * 预留3
     * not-null:true
     * default:''
     */
    private String reserve3;

    /**
     * 预留4
     * not-null:true
     * default:''
     */
    private String reserve4;

    /**
     * 预留5
     * not-null:true
     * default:''
     */
    private String reserve5;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setWeekly(Integer weekly) {
        this.weekly = weekly;
    }

    public Integer getWeekly() {
        return weekly;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getWeek() {
        return week;
    }

    public void setTimeslot(Integer timeslot) {
        this.timeslot = timeslot;
    }

    public Integer getTimeslot() {
        return timeslot;
    }

    public void setArrange(String arrange) {
        this.arrange = arrange;
    }

    public String getArrange() {
        return arrange;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    public String getReserve5() {
        return reserve5;
    }

}
