package com.xupt.dto;

public class OperatorsParam {
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
     * default:''
     */
    private String authtype;

    /**
     * 密码
     * not-null:true
     * default:''
     */
    private String passwd;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 页大小
     */
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdcardnum() {
        return idcardnum;
    }

    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAuthtype() {
        return authtype;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
