package com.thunisoft.spring.dao;


import com.thunisoft.spring.entity.User;

/**
 * @Description: 用户数据库操作类
 * @Author: Administrator
 * @CreateDate: 2018/8/28 21:49
 */
public interface IUserDao {

    /**
     * 保存用户
     * @param user 用户
     */
    void saveUser(User user);

    /**
     * 查询用户
     * @param id 主键
     * @return
     */
    User getUser(String id);
}
