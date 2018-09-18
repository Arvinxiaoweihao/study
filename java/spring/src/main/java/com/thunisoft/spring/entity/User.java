package com.thunisoft.spring.entity;

import java.util.Date;

/**
 * @Description: 用户实体
 * @Author: Administrator
 * @CreateDate: 2018/9/9 10:28
 */
public class User {
    /**主键编号*/
    private String id;
    /** 用户名. */
    private String username;
    /** 密码. */
    private String  password;
    /**部门id*/
    private String deptId;
    /**创建时间*/
    private Date createDate;


    /**
     * 获取 主键编号
     *
     * @return id 主键编号
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 主键编号
     *
     * @param id 主键编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 用户名.
     *
     * @return username 用户名.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 设置 用户名.
     *
     * @param username 用户名.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取 密码.
     *
     * @return password 密码.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置 密码.
     *
     * @param password 密码.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取 部门id
     *
     * @return deptId 部门id
     */
    public String getDeptId() {
        return this.deptId;
    }

    /**
     * 设置 部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取 创建时间
     *
     * @return createDate 创建时间
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 设置 创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deptId='" + deptId + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
