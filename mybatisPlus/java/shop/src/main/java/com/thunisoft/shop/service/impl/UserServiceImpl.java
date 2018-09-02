/*
 * @(#)UserServiceImpl.java 2017-8-28下午1:46:09 shop Copyright 2017 Thuisoft,
 * Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject
 * to license terms.
 */
package com.thunisoft.shop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thunisoft.shop.dao.IUserDao;
import com.thunisoft.shop.domain.User;
import com.thunisoft.shop.service.IProductService;
import com.thunisoft.shop.service.IUserService;

/**
 * 业务逻辑层，用户业务逻辑处理.
 * @author ljw on 2017-8-28下午1:46:09
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    /** 日志组件. */
    private final static Logger logger = LoggerFactory
            .getLogger(UserServiceImpl.class);

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Autowired
    @Qualifier(value = "productService")
    private IProductService productService;

    /**
     * 保存用户到数据库.
     * @param user 要保存的用户
     */
    @Override
    public void save(User user) {
        user.setRegisterRq(new Date());
        try {
            userDao.save(user);
            logger.info("保存用户成功");
        } catch (Exception e) {
            logger.error("保存用户失败。");
        }
    }

    /**
     * 修改用户信息.
     * @param user 要修改的用户
     */
    public void update(User user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            logger.error("修改用户失败。");
        }
        logger.info("修改用户成功");
    }

    /**
     * 删除用户信息.
     * @param id 要删除的用户的id
     */
    public void delete(Long id) {
        try {
            userDao.delete(id);
        } catch (Exception e) {
            logger.error("删除用户失败。");
        }
        logger.info("删除用户成功");
    }

    /**
     * 查询用户信息.
     * @param id 要查询的用户id.
     * @return user 查询到的用户
     */
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    /**
     * 查询所有用户.
     * @return list 用户集合
     */
    @Override
    public List<User> find() {
        return userDao.find();
    }

    /**
     * 通过用户名查询用户信息.
     * @param username 要查询的用户名
     * @return user 查询到的用户
     */
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
