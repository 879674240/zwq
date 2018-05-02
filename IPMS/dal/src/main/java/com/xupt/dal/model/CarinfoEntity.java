package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-05-02 18:55:09
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
    private String cardriverno;

    /**
     * 车牌号
     * not-null:true
     * default:''
     */
    private String carnum;

    /**
     * 车品牌
     * not-null:true
     * default:''
     */
    private String carlogo;

    /**
     * 车辆颜色
     * not-null:true
     * default:''
     */
    private String carcolor;

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

    public void setCardriverno(String cardriverno) {
        this.cardriverno = cardriverno;
    }

    public String getCardriverno() {
        return cardriverno;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarlogo(String carlogo) {
        this.carlogo = carlogo;
    }

    public String getCarlogo() {
        return carlogo;
    }

    public void setCarcolor(String carcolor) {
        this.carcolor = carcolor;
    }

    public String getCarcolor() {
        return carcolor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
