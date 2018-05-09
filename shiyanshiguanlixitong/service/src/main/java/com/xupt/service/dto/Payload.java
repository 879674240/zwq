package com.xupt.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "存放信息", description = "user2")
public class Payload {

    /**
     * 签发者
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "签发者", required = true)
    private String iss;
    /**
     * iat
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "iat", required = true)
    private String iat;
    /**
     * 过期时间
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "过期时间", required = true)
    private String exp;
    /**
     * 接收方
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "接收方", required = true)
    private String aud;
    /**
     * 面向的用户
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "面向的用户", required = true)
    private String sub;

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}
