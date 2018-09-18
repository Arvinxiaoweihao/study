package com.thunisoft.spring.service.impl;

import com.thunisoft.spring.dao.IDeptDao;
import com.thunisoft.spring.entity.Dept;
import com.thunisoft.spring.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/9 19:16
 */
@Service("DeptService")
public class DeptServiceImpl implements IDeptService {

    @Resource
    private IDeptDao deptDao;

    /**
     * 查询部门
     * @param id
     * @return
     */
    @Override
    public Dept getDept(String id) {
        return deptDao.getDept(id);
    }
}
