package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-18 15:53:17
 * @description: userinfo()
 */
public class UserinfoEntity {
    /**
     * 主键
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 账号名称
     * not-null:true
     * default:''
     */
    private String name;

    /**
     * 用户密码
     * not-null:true
     * default:'null'
     */
    private String password;

    /**
     * 权限
     * not-null:true
     * default:'0'
     */
    private Integer type;

    /**
     * 真实姓名
     * not-null:true
     * default:''
     */
    private String realname;

    /**
     * 备注
     * not-null:true
     * default:''
     */
    private String remark;

    /**
     * 预留字段1
     * not-null:true
     * default:''
     */
    private String reserve1;

    /**
     * 预留字段2
     * not-null:true
     * default:''
     */
    private String reserve2;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve2() {
        return reserve2;
    }

}
