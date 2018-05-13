package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-05-03 14:01:51
 * @description: cardinfo()
 */
public class CardinfoEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 卡编号
     * not-null:true
     * default:''
     */
    private String cardno;

    /**
     * userinfo表的idno
     * not-null:true
     * default:''
     */
    private String idno;

    /**
     * 类型
     * not-null:true
     * default:''
     */
    private String types;

    /**
     * 余额
     * not-null:true
     * default:'0'
     */
    private Integer remain;

    /**
     * 办卡时间
     * not-null:true
     * default:''
     */
    private String carstart;

    /**
     * 到期时间
     * not-null:true
     * default:''
     */
    private String carend;

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

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getIdno() {
        return idno;
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

    public void setCarstart(String carstart) {
        this.carstart = carstart;
    }

    public String getCarstart() {
        return carstart;
    }

    public void setCarend(String carend) {
        this.carend = carend;
    }

    public String getCarend() {
        return carend;
    }

}
