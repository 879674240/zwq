package com.xupt.dal.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: lenovo
 * @time: 2018-04-22 23:56:47
 * @description: cardinfo()
 */
@ApiModel(value = "车卡对象", description = "card")
public class CardinfoEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 卡号
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "卡号", required = true)
    private String idno;

    /**
     * 卡编号
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "卡编号", required = true)
    private String cardno;

    /**
     * 类型
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "类型", required = true)
    private String types;

    /**
     * 余额
     * not-null:true
     * default:'0'
     */
    @ApiModelProperty(value = "余额", required = true)
    private Integer remain;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getIdno() {
        return idno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardno() {
        return cardno;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getTypes() {
        return types;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getRemain() {
        return remain;
    }

}
