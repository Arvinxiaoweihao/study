package com.thunisoft.springboot.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description: 用户
 * @Author: Administrator
 * @CreateDate: 2018/9/17 22:30
 */
@Entity(name="t_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer sex;
    private Date birthday;


    /**
     * 获取 @Id    @GeneratedValue
     *
     * @return id @Id    @GeneratedValue
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 @Id    @GeneratedValue
     *
     * @param id @Id    @GeneratedValue
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return sex
     */
    public Integer getSex() {
        return this.sex;
    }

    /**
     * 设置
     *
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取
     *
     * @return birthday
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * 设置
     *
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
