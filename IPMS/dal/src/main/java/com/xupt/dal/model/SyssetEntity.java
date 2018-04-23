package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 16:37:02
 * @description: sysset()
 */
public class SyssetEntity {
    /**
     * id
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 停车场名称
     * not-null:true
     * default:''
     */
    private String parkname;

    /**
     * 车位数量
     * not-null:true
     * default:'0'
     */
    private Integer parktotal;

    /**
     * 入口车道数
     * not-null:true
     * default:'0'
     */
    private Integer appearlane;

    /**
     * 出口车道数
     * not-null:true
     * default:'0'
     */
    private Integer outlane;

    /**
     * 停车场地址
     * not-null:true
     * default:''
     */
    private String parkaddr;

    /**
     * 停车场电话
     * not-null:true
     * default:''
     */
    private String parktel;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParktotal(Integer parktotal) {
        this.parktotal = parktotal;
    }

    public Integer getParktotal() {
        return parktotal;
    }

    public void setAppearlane(Integer appearlane) {
        this.appearlane = appearlane;
    }

    public Integer getAppearlane() {
        return appearlane;
    }

    public void setOutlane(Integer outlane) {
        this.outlane = outlane;
    }

    public Integer getOutlane() {
        return outlane;
    }

    public void setParkaddr(String parkaddr) {
        this.parkaddr = parkaddr;
    }

    public String getParkaddr() {
        return parkaddr;
    }

    public void setParktel(String parktel) {
        this.parktel = parktel;
    }

    public String getParktel() {
        return parktel;
    }

}
