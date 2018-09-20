package com.thunisoft.springboot.service;

import com.thunisoft.springboot.domain.Dept;

/**
 * @Description: 部门逻辑处理
 * @Author: Administrator
 * @CreateDate: 2018/9/19 22:14
 */
public interface IDeptService {

    /** 新增部门. */
    Dept saveDept(Dept dept);
}
