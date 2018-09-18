package com.thunisoft.spring.dao.impl;

import com.thunisoft.spring.dao.IDeptDao;
import com.thunisoft.spring.entity.Dept;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/9 19:21
 */
@Repository("deptDao")
public class DeptDaoImpl implements IDeptDao {

    /**
     * 获取部门.
     *
     * @param id
     */
    @Override
    public Dept getDept(String id) {
        return null;
    }
}
