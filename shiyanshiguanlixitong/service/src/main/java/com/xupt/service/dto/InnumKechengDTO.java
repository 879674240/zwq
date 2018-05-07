package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: lenovo
 * @time: 2018-04-20 18:04:01
 * @description: innum()
 */
@ApiModel(value = "枚举类实体", description = "innum")
public class InnumKechengDTO {
    /**
     *
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 键名
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "键名", required = true)
    private String key;

    /**
     * 键值
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "键值", required = true)
    private String value;

    /**
     * 所属
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "所属实验室", required = true)
    private Integer order;

    /**
     * 类型
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "类型", required = true)
    private String type;

    /**
     * 应选课时
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "已选课时", required = true)
    private Integer time;

    /**
     * 已选课时
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "已选课时", required = true)
    private Integer timed;

    /**
     * 班级
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "班级", required = true)
    private String classs;

    /**
     * 代课老师
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "代课老师", required = true)
    private String teacher;

    /**
     * 学生人数
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "学生人数", required = true)
    private Integer studentNum;

    /**
     * 选修/必修
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "选修/必修", required = true)
    private String compulsory;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTimed() {
        return timed;
    }

    public void setTimed(Integer timed) {
        this.timed = timed;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getTeacher() {
        return teacher;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getCompulsory() {
        return compulsory;
    }

    public void setCompulsory(String compulsory) {
        this.compulsory = compulsory;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;

    }
}
