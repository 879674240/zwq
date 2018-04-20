package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-19 18:05:43
 * @description: experimental_task()
 */
public class ExperimentalTaskEntity {
    /**
     * id
     * not-null:true
     * default:'null'
     */
    private Integer id;

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

    /**
     * 预留字段1
     * not-null:true
     * default:''
     */
    private String reserve1;

    /**
     * 预留字段2
     * not-null:true
     * default:''
     */
    private String reserve2;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getClasss() {
        return classs;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getHours() {
        return hours;
    }

    public void setCompulsoryElective(Integer compulsoryElective) {
        this.compulsoryElective = compulsoryElective;
    }

    public Integer getCompulsoryElective() {
        return compulsoryElective;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setNumberr(String numberr) {
        this.numberr = numberr;
    }

    public String getNumberr() {
        return numberr;
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

}
