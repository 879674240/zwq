package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "实验任务编码", description = "task")
public class NumParam {
    /**
     * 编码
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "编码", required = true)
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
