package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-21 18:48:07
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
     * 类型
     * not-null:true
     * default:''
     */
    private String type;

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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getRemain() {
        return remain;
    }

}
