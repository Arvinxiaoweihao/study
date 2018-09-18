package com.thunisoft.springboot.service.impl;

import com.thunisoft.springboot.dao.IUserDao;
import com.thunisoft.springboot.pojo.User;
import com.thunisoft.springboot.service.IUserService;
import org.springframework.stereotype.Service;

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
     *
     * @return
     */
    @Override
    public List<User> listUser() {
        return userDao.findAll();
    }
}
