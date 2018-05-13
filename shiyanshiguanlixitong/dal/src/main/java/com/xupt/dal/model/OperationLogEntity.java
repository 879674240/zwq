package com.xupt.dal.model;

import java.sql.Timestamp;


/**
 * @author: lenovo
 * @time: 2018-05-13 16:53:53
 * @description: operation_log()
 */
public class OperationLogEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 账号
     * not-null:true
     * default:''
     */
    private String name;

    /**
     * 真是姓名
     * not-null:true
     * default:''
     */
    private String reallyName;

    /**
     * 路径
     * not-null:true
     * default:''
     */
    private String path;

    /**
     * 参数
     * not-null:true
     * default:''
     */
    private String params;

    /**
     * 时间戳
     * not-null:true
     * default:'CURRENT_TIMESTAMP'
     */
    private Timestamp timeStamp;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setReallyName(String reallyName) {
        this.reallyName = reallyName;
    }

    public String getReallyName() {
        return reallyName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParams() {
        return params;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

}
