package com.thunisoft.springboot.dao;

import com.thunisoft.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 用户持久层
 * @Author: Administrator
 * @CreateDate: 2018/9/17 23:01
 */
public interface IUserDao extends JpaRepository<User,Integer> {

}
