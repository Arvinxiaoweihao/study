package com.thunisoft.springboot.aspect;

import org.aspectj.lang.annotation.Before;

/**
 * @Description: 部门操作切面控制
 * @Author: Administrator
 * @CreateDate: 2018/9/20 22:27
 */
public class DeptAspect {

    @Before("execution(public * com.thunisoft.springboot.controller.DeptController.)")
    public void deal(){

    }
}
