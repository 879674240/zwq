package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-13 20:10:41
 * @description: experimental_task()
 */
public class ExperimentalTaskEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 编号
     * not-null:true
     * default:'0'
     */
    private Integer num;

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
     * 必修/选修
     * not-null:true
     * default:''
     */
    private String compulsoryElective;

    /**
     * 编号
     * not-null:true
     * default:'0'
     */
    private Integer numberr;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
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

    public void setCompulsoryElective(String compulsoryElective) {
        this.compulsoryElective = compulsoryElective;
    }

    public String getCompulsoryElective() {
        return compulsoryElective;
    }

    public void setNumberr(Integer numberr) {
        this.numberr = numberr;
    }

    public Integer getNumberr() {
        return numberr;
    }

}
