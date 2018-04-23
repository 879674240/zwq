package com.xupt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("停车信息")
public class StopParam {
    /**
     * 卡号
     * not-null:true
     * default:''
     */
    @ApiModelProperty("卡号")
    private String cardno;

    /**
     * 车牌号
     * not-null:true
     * default:''
     */
    @ApiModelProperty("车牌号")
    private String carnum;

    /**
     * 车类型
     * not-null:true
     * default:''
     */
    @ApiModelProperty("车类型")
    private String cartype;

    /**
     * 车位编号
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty("车位编号")
    private Integer carposi;

    /**
     * 收费类型
     * not-null:true
     * default:''
     */
    @ApiModelProperty("收费类型")
    private String feestype;

    /**
     * 操作员
     * not-null:true
     * default:''
     */
    @ApiModelProperty("操作员")
    private String operator;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public Integer getCarposi() {
        return carposi;
    }

    public void setCarposi(Integer carposi) {
        this.carposi = carposi;
    }

    public String getFeestype() {
        return feestype;
    }

    public void setFeestype(String feestype) {
        this.feestype = feestype;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
