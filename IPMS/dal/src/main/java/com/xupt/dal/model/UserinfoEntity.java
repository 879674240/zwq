package com.xupt.dal.model;



/**
 * @author: lenovo
 * @time: 2018-04-23 14:33:38
 * @description: userinfo()
 */
public class UserinfoEntity {
    /**
     * id
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
     * 用户姓名
     * not-null:true
     * default:''
     */
    private String username;

    /**
     * 性别（男，女）
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
     * 住址
     * not-null:true
     * default:''
     */
    private String addr;

    /**
     * 手机号
     * not-null:true
     * default:''
     */
    private String tel;

    /**
     * 卡号
     * not-null:true
     * default:''
     */
    private String cardno;

    /**
     * 车牌号
     * not-null:true
     * default:''
     */
    private String carnum;

    /**
     * 密码
     * not-null:true
     * default:''
     */
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

}
