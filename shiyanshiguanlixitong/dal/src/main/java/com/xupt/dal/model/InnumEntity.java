package com.xupt.dal.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: lenovo
 * @time: 2018-04-20 18:04:01
 * @description: innum()
 */
@ApiModel(value = "枚举类实体", description = "innum")
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

}
