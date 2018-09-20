package com.thunisoft.springboot.controller;

import com.thunisoft.springboot.domain.Dept;
import com.thunisoft.springboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 部门控制器类
 * @Author: Administrator
 * @CreateDate: 2018/9/16 21:34
 */
@RestController
@RequestMapping("/dept")//添加类的访问路径
public class DeptController {

    @Autowired
    private IDeptService deptService;

    /**
     * 查询部门
     * @return
     */
    @GetMapping
    public List<Dept> listDept(){
        return
    }

    /**
     * 新建部门
     * @param dept
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/saveDept")
    public Dept saveDept(@Valid Dept dept, BindingResult bindingResult){
        //bindingResult为验证结果
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return deptService.saveDept(dept);
    }
}
