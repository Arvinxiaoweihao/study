package com.thunisoft.shop.domain;

import java.util.Date;

/**
 * 描述： 用户实体.
 * 作者： Administrator
 * 时间： 2017年8月27日下午3:56:26
 * 版本： 1.0
 */
public class User {

    /** ID. */
    private Long id;

    /** 用户名. */
    private String username;

    /** 密码. */
    private String password = "123";

    /** 电子邮箱. */
    private String email;

    /** 用户类型：0是超级管理员，1是普特用户. */
    private Integer type = 1;

    /** 用户状态：0是启用，-1是禁用. */
    private Integer status = 0;

    /** 登陆时间. */
    private Date loginTime;

    /** 登陆ip. */
    private String loginIp;

    /** 上次登陆时间. */
    private Date lastLoginTime;

    /** 上次登陆时间. */
    private String lastLoginIp;

    /** 电话号码. */
    private String tel;

    /** 地址. */
    private String address;

    /** 昵称. */
    private String nickname;

    /** 注册时间. */
    private Date registerRq;

    /**
     * 无参构造器
     */
    public User() {
    }

    /**
     * 构造器.
     * @param username
     * @param password
     * @param email
     * @param loginTime
     * @param loginIp
     * @param tel
     * @param address
     * @param nickname
     */
    public User(String username, String password, String email, Date loginTime,
            String loginIp, String tel, String address, String nickname) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.tel = tel;
        this.address = address;
        this.nickname = nickname;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the loginTime
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime the loginTime to set
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * @return the loginIp
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp the loginIp to set
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * @return the lastLoginTime
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime the lastLoginTime to set
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return the lastLoginOp
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginOp the lastLoginOp to set
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getRegisterRq() {
        return registerRq;
    }

    public void setRegisterRq(Date registerRq) {
        this.registerRq = registerRq;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", email=" + email + ", type=" + type
                + ", status=" + status + ", loginTime=" + loginTime
                + ", loginIp=" + loginIp + ", lastLoginTime=" + lastLoginTime
                + ", lastLoginIp=" + lastLoginIp + ", tel=" + tel
                + ", address=" + address + ", nickname=" + nickname
                + ", registerRq=" + registerRq + "]";
    }

   

}
