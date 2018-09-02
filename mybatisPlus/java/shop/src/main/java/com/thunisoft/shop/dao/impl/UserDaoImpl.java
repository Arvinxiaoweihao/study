/*
 * @(#)UserDaoImpl.java 2017-8-28下午3:42:53 shop Copyright 2017 Thuisoft, Inc.
 * All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.thunisoft.shop.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.thunisoft.shop.dao.IUserDao;
import com.thunisoft.shop.domain.User;

/**
 * 数据持久层，用户数据库操作.
 * @author ljw on 2017-8-28下午3:42:53
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {


    /** 注入 sqlSessionTemplate. */
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存用户到数据库.
     * @param user 要保存的用户
     */
    @Override
    public User save(User user) {
        sqlSessionTemplate.insert("com.thunisoft.shop.mapper.UserMapper.save",
            user);
        return user;
    }

    /**
     * 修改用户信息.
     * @param user 要修改的用户
     */
    public void update(User user) {
        sqlSessionTemplate.update(
            "com.thunisoft.shop.mapper.UserMapper.update", user);
    }

    /**
     * 删除用户信息.
     * @param id 要删除的用户的id
     */
    public void delete(Long id) {
        sqlSessionTemplate.getMapper(IUserDao.class).delete(id);
    }

    /**
     * 查询用户信息.
     * @param id 要查询的用户id.
     * @return user 查询到的用户
     */
    public User getUserById(Long id) {
        return sqlSessionTemplate.getMapper(IUserDao.class).getUserById(id);
    }

    /**
     * 查询所有用户.
     * @return list 用户集合
     */
    @Override
    public List<User> find() {
        return sqlSessionTemplate.getMapper(IUserDao.class).find();
    }

    /**
     * 通过用户名查询用户信息.
     * @param username 要查询的用户名
     * @return user 查询到的用户
     */
    public User getUserByName(String username) {
        return sqlSessionTemplate.getMapper(IUserDao.class).getUserByName(username);
    }


}
