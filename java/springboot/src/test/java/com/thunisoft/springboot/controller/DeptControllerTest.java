package com.thunisoft.springboot.controller;

import com.thunisoft.springboot.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/23 13:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeptControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listDept() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/dept/listDept"))//根据访问路径全流程验证
                .andExpect(MockMvcResultMatchers.content().string("abc"))//期望结果，返回内容abc
                .andExpect(MockMvcResultMatchers.status().isOk());//期望结果,返回状态值
    }
}