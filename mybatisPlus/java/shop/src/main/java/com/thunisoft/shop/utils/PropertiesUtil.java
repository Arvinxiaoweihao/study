/*
 * @(#)PropertiesUtil.java 2017-9-11上午10:56:59
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: Properties解析工具
 * @author Administrator 
 * @date 2018年3月27日 下午11:52:55 
 * @version v1.0
 */
public class PropertiesUtil {

    /**
     * Properties解析对象
     */
    private Properties prop = null;
    
    /**
     * 带参构造器
     * @param propFilePath Properties文件相对路径
     */
    public PropertiesUtil(String propFilePath) {
        try {
            prop = new Properties();
            prop.load(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(propFilePath));
        } catch (IOException e) {
            throw new RuntimeException("加载"+propFilePath+"文件失败!",e);
        }
    }
    
    /**
     * 获取Properties文件中字段值
     * @param propName
     * @return
     */
    public String getProperty(String propName){
        String value = prop.getProperty(propName);
        if(StringUtils.isBlank(value)){
            throw new RuntimeException("加载"+propName+"配置值位空!");
        }
       return value;
    }
}
