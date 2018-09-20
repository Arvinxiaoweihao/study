package com.thunisoft.springboot.dao;

import com.thunisoft.springboot.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 部门持久层
 * @Author: Administrator
 * @CreateDate: 2018/9/19 22:15
 */
public interface IDeptDao extends JpaRepository<Dept,Integer> {
}
