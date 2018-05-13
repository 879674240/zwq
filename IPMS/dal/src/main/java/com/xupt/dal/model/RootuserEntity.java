package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-05-09 00:53:16
 * @description: rootuser()
 */
public class RootuserEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    private Integer id;

    /**
     * 账号
     * not-null:true
     * default:''
     */
    private String root;

    /**
     * 密码
     * not-null:true
     * default:''
     */
    private String password;

    /**
     * 权限类型
     * not-null:true
     * default:''
     */
    private String authtype;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getRoot() {
        return root;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype;
    }

    public String getAuthtype() {
        return authtype;
    }

}
