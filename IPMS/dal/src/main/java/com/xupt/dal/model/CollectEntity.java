package com.xupt.dal.model;

import java.util.Date;


/**
 * @author: lenovo
 * @time: 2018-05-03 15:32:42
 * @description: collect()
 */
public class CollectEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 用户名
     * not-null:true
     * default:''
     */
    private String username;

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
     * 开始时间
     * not-null:false
     * default:'null'
     */
    private String starttime;

    /**
     * 结束时间
     * not-null:false
     * default:'null'
     */
    private String endtime;

    /**
     * 金额
     * not-null:true
     * default:'0'
     */
    private Integer totalmoney;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setTotalmoney(Integer totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Integer getTotalmoney() {
        return totalmoney;
    }

}
