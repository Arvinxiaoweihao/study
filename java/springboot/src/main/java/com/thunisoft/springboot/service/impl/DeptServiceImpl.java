package com.thunisoft.springboot.service.impl;

import com.thunisoft.springboot.dao.IDeptDao;
import com.thunisoft.springboot.domain.Dept;
import com.thunisoft.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 部门逻辑处理
 * @Author: Administrator
 * @CreateDate: 2018/9/19 22:14
 */
@Service("deptService")
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDap;

    /**
     * 新增部门.
     *
     * @param dept
     */
    @Override
    public Dept saveDept(Dept dept) {
        return deptDap.save(dept);
    }
}
