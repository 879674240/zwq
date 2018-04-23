package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 15:06:56
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
     * 卡号
     * not-null:true
     * default:''
     */
    private String idno;

    /**
     * 卡编号
     * not-null:true
     * default:''
     */
    private String cardno;

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
