/*
 * @(#)NavigateAction.java 2017-8-31下午4:55:33 shop Copyright 2017 Thuisoft, Inc.
 * All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.thunisoft.shop.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thunisoft.shop.domain.User;
import com.thunisoft.shop.service.IUserService;
import com.thunisoft.shop.utils.Global;

/**
 * 表现层，用户表现控制.
 * @author ljw on 2017-8-31下午4:55:33
 */
public class UserAction extends ActionSupport {

    /**
     * 序列化编号.
     */
    private static final long serialVersionUID = 3156440429741163884L;

    /** 注入userService. */
    @Resource
    private IUserService userService;

    /** 界面获取用户信息. */
    private User user;

    /**
     * 导向方法.
     * @return String 结果名字
     */
    @Override
    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }

    /** 
    * 表单验证.
    * 方法名字可以指定验证指定方法
    */
    public void validateSave() {
        if (StringUtils.isBlank(user.getUsername())) {
            addFieldError("username_error", "用户名不能为空");
        }
        if (StringUtils.isBlank(user.getNickname())) {
            addFieldError("nickname_error", "昵称不能为空");
        }
        if (StringUtils.isBlank(user.getTel())) {
            addFieldError("tel_error", "电话号码不能为空");
        }
        if (StringUtils.isBlank(user.getEmail())) {
            addFieldError("email_error", "邮箱不能为空");
        }
    }

    /**
     * 新增跳转.
     * @return String 结果名字
     * @throws Exception
     */
    public String input() throws Exception {
        return ActionSupport.INPUT;
    }

    /**
     * 修改跳转.
     * @return String 结果名字
     * @throws Exception
     */
    public String update() throws Exception {
        Long id = user.getId();
        if (id != null) {
            user = userService.getUserById(id);
        }
        return ActionSupport.INPUT;
    }

    /**
     * 保存跳转.
     * @return String 结果名字
     * @throws Exception
     */
    public String save() throws Exception {
        if (user.getId() == null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * 删除跳转.
     * @return String 结果名字
     * @throws Exception
     */
    public String delete() throws Exception {
        userService.delete(user.getId());
        return ActionSupport.SUCCESS;
    }

    /**
     * 用户列表.
     * @return String 结果名字
     */
    public String list() throws Exception {
        PageHelper.startPage(1, 10);
        List<User> userList = userService.find();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        long total = pageInfo.getTotal(); //获取总记录数
        ActionContext.getContext().put("userList", userList);
        return Global.LIST;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
