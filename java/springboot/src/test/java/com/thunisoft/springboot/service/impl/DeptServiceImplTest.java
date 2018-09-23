package com.thunisoft.springboot.service.impl;

import com.thunisoft.springboot.domain.Dept;
import com.thunisoft.springboot.service.IDeptService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/23 11:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceImplTest {

    @Autowired
    private IDeptService deptService;

    @Test
    @Transactional
    public void getDept() throws Exception {
        Dept dept = (Dept) deptService.getDept(13);
        Assert.assertEquals(Integer.valueOf(60),dept.getNum());
    }
}