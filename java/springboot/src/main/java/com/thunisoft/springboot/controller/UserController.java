package com.thunisoft.springboot.controller;

import com.thunisoft.springboot.domain.User;
import com.thunisoft.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/9/13 22:51
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController {

    /** 注入userService. */
    @Autowired
    private IUserService userService;



    /**
     * 查询用户列表
     */
    @GetMapping(value="/listUser")
    public List<User> listUser() {
        return userService.listUser();
    }

    /**
     * 保存用户
     * @param name 名字
     * @param sex 性别
     */
    @PostMapping(value="/saveUser")
    public User saveUser(@RequestParam("name") String name,@RequestParam("sex") Integer sex){
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        return userService.saveUser(user);
    }

    /**
     * 查询用户
     * @param id ID
     * @return
     */
    @GetMapping(value="/getUser")
    public User getUser(@RequestParam("id") Integer id){
        return userService.getUser(id);
    }

    /**
     * 查询用户
     * @param id ID
     * @return
     */
    @GetMapping(value="/getDefaultUser")
    public User getDefaultUser(@RequestParam(value="id",required = false,defaultValue = "20") Integer id){
        return userService.getUser(id);
    }

    /**
     * 查询用户
     * @param name 名字
     * @return
     */
    @GetMapping(value="/getUserByName")
    public List<User> getUser(@RequestParam("name") String name){
        return userService.getUser(name);
    }

    /**
     * 修改用户
     * @param id ID
     * @param name 名字
     * @param sex 性别
     * @return
     */
    @PutMapping(value="/updateUser")
    public User updateUser(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("sex") Integer sex){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     * @param id ID
     */
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") Integer id){
        userService.deleteUser(id);
    }



}
