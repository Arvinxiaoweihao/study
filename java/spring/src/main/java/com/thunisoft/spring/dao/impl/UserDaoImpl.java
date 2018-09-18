package com.thunisoft.spring.dao.impl;

import com.thunisoft.spring.dao.IUserDao;
import com.thunisoft.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户数据库操作
 * @Author: Administrator
 * @CreateDate: 2018/8/28 21:59
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存用户
     * @param user 用户
     */
    @Override
    public void saveUser(User user) {
    }

    /**
     * 查询用户
     * @param id 主键
     * @return
     */
    @Override
    public User getUser(String id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
    }
}
