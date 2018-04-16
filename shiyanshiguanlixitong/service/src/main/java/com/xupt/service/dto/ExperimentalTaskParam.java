package com.xupt.service.dto;

public class ExperimentalTaskParam {
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

    /**
     * 当前页
     * not-null:true
     * default:'0'
     */
    private int currentPage;

    /**
     * 页面大小
     * not-null:true
     * default:'0'
     */
    private int pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getCompulsoryElective() {
        return compulsoryElective;
    }

    public void setCompulsoryElective(String compulsoryElective) {
        this.compulsoryElective = compulsoryElective;
    }

    public Integer getNumberr() {
        return numberr;
    }

    public void setNumberr(Integer numberr) {
        this.numberr = numberr;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
