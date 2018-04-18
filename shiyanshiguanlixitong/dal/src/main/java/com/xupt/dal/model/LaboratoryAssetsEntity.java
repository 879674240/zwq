package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-18 11:16:20
 * @description: laboratory_assets()
 */
public class LaboratoryAssetsEntity {
    /**
     * id
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 资产编号
     * not-null:true
     * default:''
     */
    private String num;

    /**
     * 资产名称
     * not-null:true
     * default:''
     */
    private String name;

    /**
     * 状态
     * not-null:true
     * default:''
     */
    private String status;

    /**
     * 所属实验室
     * not-null:true
     * default:''
     */
    private String belong;

    /**
     * 负责人
     * not-null:true
     * default:''
     */
    private String personInCharge;

    /**
     * 备注
     * not-null:true
     * default:''
     */
    private String remark;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getBelong() {
        return belong;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
