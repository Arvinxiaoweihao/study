package com.thunisoft.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 用户配置
 * @Author: Administrator
 * @CreateDate: 2018/9/16 20:03
 */
@Component("userProperties")
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    /** 用户名. */
    private String userName;
    /** 年龄. */
    private Integer age;
    /** 简介. */
    private String info;


    /**
     * 获取 用户名.
     *
     * @return userName 用户名.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户名.
     *
     * @param userName 用户名.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 年龄.
     *
     * @return age 年龄.
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * 设置 年龄.
     *
     * @param age 年龄.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取 简介.
     *
     * @return info 简介.
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * 设置 简介.
     *
     * @param info 简介.
     */
    public void setInfo(String info) {
        this.info = info;
    }
}
