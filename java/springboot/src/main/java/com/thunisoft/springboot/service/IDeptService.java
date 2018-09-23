package com.thunisoft.springboot.service;

import com.thunisoft.springboot.domain.Dept;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * @Description: 部门逻辑处理
 * @Author: Administrator
 * @CreateDate: 2018/9/19 22:14
 */
public interface IDeptService {

    /** 新增部门. */
    Dept saveDept(Dept dept);

    /** 查询部门. */
    List<Dept> listDept();

    /** 查询部门. */
    Object getDept(Integer id) throws Exception;
}
