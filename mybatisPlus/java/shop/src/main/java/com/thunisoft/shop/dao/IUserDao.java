/*
 * @(#)IUserDao.java 2017-8-28下午3:42:22
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.thunisoft.shop.domain.User;

/**
 * 用户数据库操作.
 * @author ljw on 2017-8-28下午3:42:22
 */
public interface IUserDao {

    /**
     * 保存用户到数据库.
     * @param user 要保存的用户
     * @return user 入库后的用户
     */
    public User save(User user);
    
    /**
     * 修改用户信息.
     * @param user 要修改的用户
     */
    public void update(User user);
    
    /**
     * 删除用户信息.
     * @param id 要删除的用户的id
     */
    @Delete("delete from t_user where id=#{id}")
    public void delete(Long id);
    
    /**
     * 根据id查询用户信息.
     * @param id 要查询的用户id.
     * @return user 查询到的用户
     */
    @Select("SELECT * FROM t_user WHERE id = #{id}")
    public User getUserById(Long id);
    
    
    /**
     * 查询所有用户.
     * @return list 用户集合
     */
    @Select("select * from t_user")
    public List<User> find();
    
    /**
     * 通过用户名查询用户信息.
     * @param username 要查询的用户名
     * @return user 查询到的用户
     */
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    public User getUserByName(String username);
    
}
