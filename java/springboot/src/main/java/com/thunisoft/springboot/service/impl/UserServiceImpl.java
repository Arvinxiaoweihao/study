package com.thunisoft.springboot.service.impl;

import com.thunisoft.springboot.dao.IUserDao;
import com.thunisoft.springboot.domain.User;
import com.thunisoft.springboot.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户逻辑层
 * @Author: Administrator
 * @CreateDate: 2018/9/17 23:04
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    /** 注入userDao. */
    private IUserDao userDao;

    /**
     * 查询用户集合
     * @return
     */
    @Override
    public List<User> listUser() {
        return userDao.findAll();
    }

    /**
     * 保存用户
     *
     * @param user 用户
     */
    @Override
    @Transactional
    public User saveUser(User user) {
        return userDao.save(user);
    }

    /**
     * 查询用户
     *
     * @param id ID
     * @return
     */
    @Override
    public User getUser(Integer id) {
        return userDao.getOne(id);
    }

    /**
     * 查询用户
     * @param name 名字
     * @return
     */
    @Override
    public List<User> getUser(String name) {
        return userDao.getUserByName(name);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return
     */
    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }
}
