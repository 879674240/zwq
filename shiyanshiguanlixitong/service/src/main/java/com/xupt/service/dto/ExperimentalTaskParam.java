package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "实验任务查询参数", description = "user2")
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
    @ApiModelProperty(value = "编号", required = true)
    private Integer num;

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
     * 必修/选修
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "0:必修,1:选修", required = true)
    private String compulsoryElective;

    /**
     * 编号
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "编号", required = true)
    private Integer numberr;

    /**
     * 当前页
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "当前页", required = true)
    private int currentPage;

    /**
     * 页面大小
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "页面大小", required = true)
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
