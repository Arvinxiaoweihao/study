package com.thunisoft.springboot.dao;

import com.thunisoft.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 用户持久层
 * @Author: Administrator
 * @CreateDate: 2018/9/17 23:01
 */
public interface IUserDao extends JpaRepository<User,Integer> {

    /** 自定义根据用户名查询用户. */
    List<User> getUserByName(String name);
}
