package com.xupt.service.dto;

import com.xupt.dal.model.InnumEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-20 18:04:01
 * @description: innum()
 */
@ApiModel(value = "枚举类实体", description = "innum")
public class InnumSysDTO {
    /**
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
     * 类型
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "类型", required = true)
    private String type;

    /**
     * 教室编号集合
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "教室编号集合", required = true)
    private List<InnumEntity> innumEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<InnumEntity> getInnumEntityList() {
        return innumEntityList;
    }

    public void setInnumEntityList(List<InnumEntity> innumEntityList) {
        this.innumEntityList = innumEntityList;
    }
}