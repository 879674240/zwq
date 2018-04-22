package com.xupt.dal.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: lenovo
 * @time: 2018-04-22 01:05:53
 * @description: operators()
 */
@ApiModel(value = "用户对象", description = "user2")
public class OperatorsEntity {
    /**
     * 
     * not-null:true
     * default:'null'
     */
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 编号
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "编号", required = true)
    private String idno;

    /**
     * 姓名
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    /**
     * 性别
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "性别", required = true)
    private String sex;

    /**
     * 年龄
     * not-null:true
     * default:'1'
     */
    @ApiModelProperty(value = "年龄", required = true)
    private Integer age;

    /**
     * 身份证号
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "身份证号", required = true)
    private String idcardnum;

    /**
     * 手机号码
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String phonenum;

    /**
     * 邮箱
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "邮箱", required = true)
    private String email;

    /**
     * 地址
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "地址", required = true)
    private String addr;

    /**
     * 权限类型
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "权限类型", required = true)
    private String authtype;

    /**
     * 密码
     * not-null:true
     * default:''
     */
    @ApiModelProperty(value = "密码", required = true)
    private String passwd;

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

}
