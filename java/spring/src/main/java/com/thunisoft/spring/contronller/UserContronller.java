package com.thunisoft.spring.contronller;

import com.thunisoft.spring.entity.User;
import com.thunisoft.spring.service.IUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Description: 用户控制类
 * @Author: Administrator
 * @CreateDate: 2018/8/28 21:51
 */
@Controller("userContronller")
public class UserContronller {

    @Resource
    private IUserService userService;

    public void saveUser(){
        User user = new User();
        user.setId("1");
        user.setUsername("张三");
        user.setPassword("123");
        userService.saveUser(user);
    }

    public User getUser(String id){
        return userService.getUser(id);
    }

}
