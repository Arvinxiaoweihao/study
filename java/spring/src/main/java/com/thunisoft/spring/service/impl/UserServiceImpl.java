package com.thunisoft.spring.service.impl;

import com.thunisoft.spring.dao.IUserDao;
import com.thunisoft.spring.entity.User;
import com.thunisoft.spring.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Administrator
 * @CreateDate: 2018/8/28 21:57
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    /**
     * 保存用户
     * @param user 用户
     */
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 查询用户
     * @param id 主键
     * @return
     */
    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }
}
