package com.thunisoft.springboot.service;

import com.thunisoft.springboot.pojo.User;

import java.util.List;

/**
 * @Description: 用户逻辑层
 * @Author: Administrator
 * @CreateDate: 2018/9/17 23:03
 */
public interface IUserService {

    /**
     * 查询用户集合
     * @return
     */
    List<User> listUser();
}
