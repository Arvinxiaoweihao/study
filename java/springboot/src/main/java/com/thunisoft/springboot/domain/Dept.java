package com.thunisoft.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @Description: 部门
 * @Author: Administrator
 * @CreateDate: 2018/9/19 22:16
 */
@Entity(name="t_dept")
public class Dept {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String deptName;
    @Min(value=50,message = "人数不能少于50人")
    private Integer num;


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
     * @return deptName
     */
    public String getDeptName() {
        return this.deptName;
    }

    /**
     * 设置
     *
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    /**
     * 获取 @Min(value=50message = "人数不能少于50人")
     *
     * @return num @Min(value=50message = "人数不能少于50人")
     */
    public Integer getNum() {
        return this.num;
    }

    /**
     * 设置 @Min(value=50message = "人数不能少于50人")
     *
     * @param num @Min(value=50message = "人数不能少于50人")
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}
