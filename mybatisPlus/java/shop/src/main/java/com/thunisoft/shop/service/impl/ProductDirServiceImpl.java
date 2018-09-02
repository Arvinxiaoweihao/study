/*
 * @(#)ProductDirServiceImpl.java 2017-9-25下午5:43:45
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.thunisoft.shop.dao.IProductDirDao;
import com.thunisoft.shop.domain.ProductDir;
import com.thunisoft.shop.service.IProductDirService;

/**
 * 商品分类业务处理.
 * @author ljw on 2017-9-25下午5:43:45
 */
@Service("productDirService")
public class ProductDirServiceImpl implements IProductDirService{

    /** 日志组件. */
    private final static Logger logger = LoggerFactory.getLogger(ProductDirServiceImpl.class);
    
    /**注入productDirDa.*/
    @Resource
    private IProductDirDao productDirDao;
    
    /**
     * 查询所有商品分类
     * @return list商品分类列表
     */
    @Override
    public List<ProductDir> find() {
        return productDirDao.find();
    }

    /**
     * 查询所有商品分类的id和名字
     * @return list商品分类列表
     */
    @Override
    public List<ProductDir> findIdAndName() {
        return productDirDao.findIdAndName();
    }

}
