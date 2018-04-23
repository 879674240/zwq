package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 16:19:54
 * @description: admin()
 */
public class AdminEntity {
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
     * 姓名
     * not-null:true
     * default:''
     */
    private String name;

    /**
     * 性别
     * not-null:true
     * default:''
     */
    private String sex;

    /**
     * 年龄
     * not-null:true
     * default:'1'
     */
    private Integer age;

    /**
     * 身份证号
     * not-null:true
     * default:''
     */
    private String idcardnum;

    /**
     * 手机号码
     * not-null:true
     * default:''
     */
    private String phonenum;

    /**
     * 邮箱
     * not-null:true
     * default:''
     */
    private String email;

    /**
     * 地址
     * not-null:true
     * default:''
     */
    private String addr;

    /**
     * 权限类型
     * not-null:true
     * default:'操作员'
     */
    private String authtype;

    /**
     * 密码
     * not-null:true
     * default:''
     */
    private String passwd;

    /**
     * 权限状态(已启用,已禁用)
     * not-null:true
     * default:''
     */
    private String authstatus;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum;
    }

    public String getIdcardnum() {
        return idcardnum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype;
    }

    public String getAuthtype() {
        return authtype;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setAuthstatus(String authstatus) {
        this.authstatus = authstatus;
    }

    public String getAuthstatus() {
        return authstatus;
    }

}
