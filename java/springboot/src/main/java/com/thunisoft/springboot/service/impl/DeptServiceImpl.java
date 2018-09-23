package com.thunisoft.springboot.service.impl;

import com.thunisoft.springboot.constant.enums.DeptResultEnum;
import com.thunisoft.springboot.dao.IDeptDao;
import com.thunisoft.springboot.domain.Dept;
import com.thunisoft.springboot.exception.DeptException;
import com.thunisoft.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @Description: 部门逻辑处理
 * @Author: Administrator
 * @CreateDate: 2018/9/19 22:14
 */
@Service("deptService")
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    /**
     * 新增部门.
     *
     * @param dept
     */
    @Override
    public Dept saveDept(Dept dept) {
        return deptDao.save(dept);
    }

    /**
     * 查询部门.
     */
    @Override
    public List<Dept> listDept() {
        return deptDao.findAll();
    }

    /**
     * 查询部门.
     *
     * @param id
     */
    @Override
    public Object getDept(Integer id) {
        Dept dept = deptDao.getOne(id);
        Integer num = dept.getNum();
        if(num < 5){
            throw new DeptException(DeptResultEnum.FAILED_LESS_FIVE);
        }else if(5 <= num && num <= 50){
            throw new DeptException(DeptResultEnum.FAILED_LESS_FIFTY);
        }
        return dept;
    }
}
