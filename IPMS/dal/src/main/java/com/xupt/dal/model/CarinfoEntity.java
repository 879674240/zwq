package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 15:13:49
 * @description: carinfo()
 */
public class CarinfoEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 编号
     * not-null:true
     * default:''
     */
    private String idno;

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
    private String type;

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

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
