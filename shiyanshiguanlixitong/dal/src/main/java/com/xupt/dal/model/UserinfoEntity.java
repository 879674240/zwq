package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-13 20:10:41
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

}
