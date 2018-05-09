package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "登录信息", description = "user2")
public class LoginParam {
    /**
     * 账号
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "账号", required = true)
    private String name;

    /**
     * 密码
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
