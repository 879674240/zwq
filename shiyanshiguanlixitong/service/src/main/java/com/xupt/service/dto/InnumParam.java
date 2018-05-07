package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "枚举类参数", description = "innum")
public class InnumParam {
    @ApiModelProperty(value = "类型", required = true)
    private String type;
    @ApiModelProperty(value = "所属实验室编号", required = true)
    private Integer order;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
