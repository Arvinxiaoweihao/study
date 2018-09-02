/*
 * @(#)NavigateAction.java 2017-8-31下午4:55:33
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thunisoft.shop.utils.Global;

/**
 * 跳转用的action.
 * @author ljw on 2017-8-31下午4:55:33
 */
public class NavigateAction extends ActionSupport{

    /**
     * 序列化编号.
     */
    private static final long serialVersionUID = 3156440429741163884L;


    /**
     * 后台首页导向.
     * @return String 结果名字
     */
    @Override
    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }
    
    /**
     * 后天首页顶部加载导向.
     * @return String 结果名字
     * @throws Exception
     */
    public String top() throws Exception {
        Object user_in_session = ActionContext.getContext().getSession().get("USER_IN_SESSION");
        System.out.println(user_in_session);
        return Global.TOP;
    }
    
    /**
     * 后天首页菜单加载导向.
     * @return String 结果名字
     * @throws Exception
     */
    public String menu() throws Exception {
        return Global.MENU;
    }
    
    /**
     * 后天首页主体加载导向.
     * @return String 结果名字
     * @throws Exception
     */
    public String main() throws Exception {
        return Global.MAIN;
    }


    
}
