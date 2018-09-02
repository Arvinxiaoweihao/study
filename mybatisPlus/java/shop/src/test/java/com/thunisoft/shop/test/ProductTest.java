/*
 * @(#)ProductTest.java 2017-8-29上午9:46:24
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.service.IProductService;

/**
 * @author ljw on 2017-8-29上午9:46:24
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml") //相对于calsspath的路径  
public class ProductTest {

    @Autowired
    private IProductService productService;

    
    @Test
    public void testFind() throws Exception {

    }
}
