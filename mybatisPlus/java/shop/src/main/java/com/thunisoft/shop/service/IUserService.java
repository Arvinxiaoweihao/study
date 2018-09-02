/*
 * @(#)IUserService.java 2017-8-28上午11:38:31
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.service;

import java.util.List;

import com.thunisoft.shop.domain.User;

/**
 * 用户业务处理.
 * @author ljw on 2017-8-28上午11:38:31
 */
public interface IUserService {

    /**
     * 保存用户到数据库.
     * @param user 要保存的用户
     */
    public void save(User user);
    
    /**
     * 修改用户信息.
     * @param user 要修改的用户
     */
    public void update(User user);
    
    /**
     * 删除用户信息.
     * @param id 要删除的用户的id
     */
    public void delete(Long id);
    
    /**
     * 根据id查询用户信息.
     * @param id 要查询的用户id.
     * @return user 查询到的用户
     */
    public User getUserById(Long id);
    
    /**
     * 查询所有用户.
     * @return list 用户集合
     */
    public List<User> find();
    
    /**
     * 通过用户名查询用户信息.
     * @param username 要查询的用户名
     * @return user 查询到的用户
     */
    public User getUserByName(String username);
}
