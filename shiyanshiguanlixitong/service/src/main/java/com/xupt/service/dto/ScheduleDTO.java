package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "排课计划页面返回数据", description = "user2")
public class ScheduleDTO {
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
    @ApiModelProperty(value = "操作人", required = true)
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
     * 专业
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "专业", required = true)
    private String major;

    /**
     * 班级
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "班级", required = true)
    private String classs;

    /**
     * 学生人数
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "学生人数", required = true)
    private Integer studentNum;

    /**
     * 课程
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "课程", required = true)
    private String subject;

    /**
     * 课时
     * not-null:true
     * default:'24'
     */
    @ApiModelProperty(value = "课时", required = true)
    private Integer hours;

    /**
     * 0:必修/1:选修
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "0:必修/1:选修", required = true)
    private Integer compulsoryElective;

    /**
     * 任课老师
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "任课老师", required = true)
    private String teacher;

    /**
     * 编号
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "编号", required = true)
    private String numberr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeekly() {
        return weekly;
    }

    public void setWeekly(Integer weekly) {
        this.weekly = weekly;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Integer timeslot) {
        this.timeslot = timeslot;
    }

    public String getArrange() {
        return arrange;
    }

    public void setArrange(String arrange) {
        this.arrange = arrange;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getCompulsoryElective() {
        return compulsoryElective;
    }

    public void setCompulsoryElective(Integer compulsoryElective) {
        this.compulsoryElective = compulsoryElective;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getNumberr() {
        return numberr;
    }

    public void setNumberr(String numberr) {
        this.numberr = numberr;
    }
}
