package com.thunisoft.springboot.controller;

import com.thunisoft.springboot.pojo.User;
import com.thunisoft.springboot.pojo.UserProperties;
import com.thunisoft.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/13 22:51
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController {


    @Autowired
    /** 注入userService. */
    private IUserService userService;

    @GetMapping(value="/listUser")
    /**
     * 查询用户列表
     */
    public List<User> listUser(){
        return userService.listUser();
    }
}
