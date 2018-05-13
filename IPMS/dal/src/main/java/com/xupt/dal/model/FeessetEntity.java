package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-05-03 14:03:33
 * @description: feesset()
 */
public class FeessetEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 卡类型
     * not-null:true
     * default:''
     */
    private String cardtype;

    /**
     * 收费类型
     * not-null:true
     * default:''
     */
    private String feestupe;

    /**
     * 单位时间
     * not-null:true
     * default:'0'
     */
    private Integer unittime;

    /**
     * 单位金额
     * not-null:true
     * default:'0'
     */
    private Integer unitmoney;

    /**
     * 收费标准号
     * not-null:true
     * default:''
     */
    private String feesstand;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setFeestupe(String feestupe) {
        this.feestupe = feestupe;
    }

    public String getFeestupe() {
        return feestupe;
    }

    public void setUnittime(Integer unittime) {
        this.unittime = unittime;
    }

    public Integer getUnittime() {
        return unittime;
    }

    public void setUnitmoney(Integer unitmoney) {
        this.unitmoney = unitmoney;
    }

    public Integer getUnitmoney() {
        return unitmoney;
    }

    public void setFeesstand(String feesstand) {
        this.feesstand = feesstand;
    }

    public String getFeesstand() {
        return feesstand;
    }

}
