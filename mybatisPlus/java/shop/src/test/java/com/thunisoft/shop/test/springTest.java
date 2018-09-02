/*
 * @(#)springTest.java 2017-9-1上午10:37:38
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thunisoft.shop.domain.User;
import com.thunisoft.shop.service.IUserService;

/**
 * 不用spring基层的junit测试
 * @author ljw on 2017-9-1上午10:37:38
 */
public class springTest {
    
    @Test
    public void testGet() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       IUserService useService = (IUserService) context.getBean("userService");
        User user = useService.getUserById(2L);
        System.out.println(user);
    }

}
