package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-16 21:42:06
 * @description: innum()
 */
public class InnumEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 键值
     * not-null:true
     * default:''
     */
    private String value;

    /**
     * 类型
     * not-null:true
     * default:'0'
     */
    private Integer type;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

}
