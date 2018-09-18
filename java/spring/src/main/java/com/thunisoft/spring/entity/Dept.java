package com.thunisoft.spring.entity;

import java.util.Date;

/**
 * @Description: 部门
 * @Author: Administrator
 * @CreateDate: 2018/9/9 18:57
 */
public class Dept {
    /**主键编号*/
    private String id;
    /** 部门名. */
    private String deptName;
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
     * 获取 部门名.
     *
     * @return deptName 部门名.
     */
    public String getDeptName() {
        return this.deptName;
    }

    /**
     * 设置 部门名.
     *
     * @param deptName 部门名.
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
        return "Dept{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
