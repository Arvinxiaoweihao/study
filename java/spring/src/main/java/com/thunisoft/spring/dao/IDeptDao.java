package com.thunisoft.spring.dao;

import com.thunisoft.spring.entity.Dept;

/**
 * @Description: 部门持久层操作
 * @Author: Administrator
 * @CreateDate: 2018/9/9 19:19
 */
public interface IDeptDao {
    /** 获取部门. */
    Dept getDept(String id);

}
