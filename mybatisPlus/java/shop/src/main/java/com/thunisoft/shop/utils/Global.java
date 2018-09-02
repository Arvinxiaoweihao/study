/*
 * @(#)Global.java 2017-8-31下午5:10:24 shop Copyright 2017 Thuisoft, Inc. All
 * rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */
package com.thunisoft.shop.utils;

/**
 * 全局变量.
 * @author ljw on 2017-8-31下午5:10:24
 */
public class Global {

    /** 后台首页. */
    public static final String INDEX = "index";

    /** 首页头部. */
    public static final String TOP = "top";

    /** 首页菜单. */
    public static final String MENU = "menu";

    /** 首页主体. */
    public static final String MAIN = "main";
    
    /** 每个模块默认跳到列表界面. */
    public static final String LIST = "list";
    
    /** ftp配置文件 */
    public static final String FTP_PROPERTIES = "ftp-storage.properties";

    /**验证码*/
    public static final String VERIFYCODE = "verifyCode";

    /**验证码图片宽*/
    public static final Integer VERIFYCODE_WIDTH = 100;

    /**验证码图片高*/
    public static final Integer VERIFYCODE_HEIGHT = 30;

    /**登录用户*/
    public static final String USER_IN_SESSION = "USER_IN_SESSION";
    
    /**商品编号*/
    public static final String SHOPPINGCART_IN_SESSION = "SHOPPINGCART_IN_SESSION";
}
