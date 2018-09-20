package com.thunisoft.springboot.service;

import com.thunisoft.springboot.domain.User;

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

    /**
     * 保存用户
     * @param user 用户
     */
    User saveUser(User user);

    /**
     * 查询用户
     * @param id ID
     * @return
     */
    User getUser(Integer id);

    /**
     * 查询用户
     * @param name 名字
     * @return
     */
    List<User> getUser(String name);

    /**
     * 修改用户
     * @param user 用户
     * @return
     */
    User updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);
}
