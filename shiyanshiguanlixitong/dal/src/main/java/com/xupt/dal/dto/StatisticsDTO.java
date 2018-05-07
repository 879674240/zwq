package com.xupt.dal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "统计数据", description = "task")
public class StatisticsDTO {

    /**
     * id
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 编码
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "编码", required = true)
    private String num;

    /**
     * 学生人数
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "学生人数", required = true)
    private Integer studentNum;

    /**
     * 课时
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "课时", required = true)
    private Integer hours;

    /**
     * 总课时
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "总课时", required = true)
    private Integer totalHours;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
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
