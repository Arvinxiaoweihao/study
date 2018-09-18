package com.thunisoft.spring.service;

import com.thunisoft.spring.entity.Dept;

/**
 * @Description: 部门业务处理
 * @Author: Administrator
 * @CreateDate: 2018/9/9 19:13
 */
public interface IDeptService {
    
    /** 查询部门. */
    Dept getDept(String id);
}
