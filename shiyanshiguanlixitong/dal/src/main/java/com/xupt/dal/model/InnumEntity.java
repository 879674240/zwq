package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-20 18:04:01
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
     * 键名
     * not-null:true
     * default:'0'
     */
    private String key;

    /**
     * 键值
     * not-null:true
     * default:''
     */
    private String value;

    /**
     * 所属
     * not-null:true
     * default:'0'
     */
    private Integer order;

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

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

}
