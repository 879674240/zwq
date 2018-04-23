package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 17:11:53
 * @description: stop()
 */
public class StopEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 卡号
     * not-null:true
     * default:''
     */
    private String cardno;

    /**
     * 车牌号
     * not-null:true
     * default:''
     */
    private String carnum;

    /**
     * 车类型
     * not-null:true
     * default:''
     */
    private String cartype;

    /**
     * 车位编号
     * not-null:true
     * default:'1'
     */
    private String carposi;

    /**
     * 收费类型
     * not-null:true
     * default:''
     */
    private String feestype;

    /**
     * 操作员
     * not-null:true
     * default:''
     */
    private String operator;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCarposi(String carposi) {
        this.carposi = carposi;
    }

    public String getCarposi() {
        return carposi;
    }

    public void setFeestype(String feestype) {
        this.feestype = feestype;
    }

    public String getFeestype() {
        return feestype;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

}
