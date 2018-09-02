/*
 * @(#)LogoutAction.java 2017-9-7下午1:48:11
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.thunisoft.shop.domain.User;
import com.thunisoft.shop.service.IUserService;
import com.thunisoft.shop.utils.Global;
import com.thunisoft.shop.utils.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 表现层，登录/退出控制
 * @author ljw on 2017-9-7下午1:48:11
 */
public class LogoutAction extends ActionSupport{

    /**
     * 序列化id.
     */
    private static final long serialVersionUID = -3765161686147082169L;

    /** 注入userService. */
    @Resource
    private IUserService userService;
    
    /** 界面获取用户信息. */
    private User user;

    /**验证码*/
    private String code;
    
    /**
     * 导向方法.
     * @return String 结果名字
     */
    @Override
    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }
    
    /** 
     * 登录验证.
     */
    public void validateLogin() {
        if(StringUtils.isBlank(user.getUsername())){
            addFieldError("username_error", "用户名不能为空");
        }
        if(StringUtils.isBlank(user.getPassword())){
            addFieldError("password_error", "密码不能为空");
        }
        if(StringUtils.isBlank(code)){
            addFieldError("code_error", "验证码不能为空");
        }
    }
    
    /**
     * 登录.
     * 加在目标方法上@InputConfig
     * @return String 结果名字
     */
    @InputConfig(resultName="success")
    public String login() throws Exception {
        User tempUser = userService.getUserByName(user.getUsername());
        if(tempUser==null){
            addFieldError("username_error", "用户名不存在");
            return ActionSupport.SUCCESS;
        }else if(!user.getPassword().equals(tempUser.getPassword())){
            addFieldError("password_error", "密码不正确");
            return ActionSupport.SUCCESS;
        }
        String verifyCode = (String) ActionContext.getContext().getSession().get(Global.VERIFYCODE);
        if(!code.equals(verifyCode)){
            addFieldError("code_error", "验证码不正确");
            return ActionSupport.SUCCESS;
        }

        ActionContext.getContext().getSession().put(Global.USER_IN_SESSION, tempUser);
        return Global.INDEX;
    }

    /**
     * 注销.
     * 加在目标方法上@InputConfig
     * @return String 结果名字
     */
    public String logout() throws Exception {
        ActionContext.getContext().getSession().remove(Global.USER_IN_SESSION);
        return ActionSupport.LOGIN;
    }

    /**
     * 获取验证码.r
     * @return String 结果名字
     */
    public String verifyCode() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        //生成随机字串+生成验证图
        String verifyCode = VerifyCodeUtil.outputVerifyImage(Global.VERIFYCODE_WIDTH,Global.VERIFYCODE_HEIGHT,response.getOutputStream(),4);
        //放入request
        request.getSession().setAttribute(Global.VERIFYCODE,verifyCode.toLowerCase());
        return ActionSupport.NONE;
    }


    //===================前台往后台传值====================
    public void setUser(User user) {
        this.user = user;
    }
    public void setCode(String code) {
        this.code = code;
    }

    //===================后台往前台传值====================

    public User getUser() {
        return user;
    }
    public String getCode() {
        return code;
    }

    
}
