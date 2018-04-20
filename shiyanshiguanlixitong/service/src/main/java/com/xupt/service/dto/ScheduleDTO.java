package com.xupt.service.dto;

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
    private Integer weekly;

    /**
     * 星期
     * not-null:true
     * default:'1'
     */
    private Integer week;

    /**
     * 时间段
     * not-null:true
     * default:'0'
     */
    private Integer timeslot;

    /**
     * 任务安排
     * not-null:true
     * default:''
     */
    private String arrange;

    /**
     * 操作人
     * not-null:true
     * default:''
     */
    private String operator;

    /**
     * 实验室房间号
     * not-null:true
     * default:'1'
     */
    private String room;

    /**
     * 备注
     * not-null:true
     * default:''
     */
    private String remark;

    /**
     * 专业
     * not-null:true
     * default:''
     */
    private String major;

    /**
     * 班级
     * not-null:true
     * default:''
     */
    private String classs;

    /**
     * 学生人数
     * not-null:true
     * default:'0'
     */
    private Integer studentNum;

    /**
     * 课程
     * not-null:true
     * default:''
     */
    private String subject;

    /**
     * 课时
     * not-null:true
     * default:'24'
     */
    private Integer hours;

    /**
     * 0:必修/1:选修
     * not-null:true
     * default:'0'
     */
    private Integer compulsoryElective;

    /**
     * 任课老师
     * not-null:true
     * default:''
     */
    private String teacher;

    /**
     * 编号
     * not-null:true
     * default:'0'
     */
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
