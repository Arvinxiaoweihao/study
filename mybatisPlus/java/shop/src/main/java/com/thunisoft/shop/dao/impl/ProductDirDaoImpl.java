/*
 * @(#)ProductDirServiceImpl.java 2017-9-25下午5:43:45
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.thunisoft.shop.dao.IProductDirDao;
import com.thunisoft.shop.domain.ProductDir;

/**
 * 商品分类业务处理.
 * @author ljw on 2017-9-25下午5:43:45
 */
@Repository("productDirDao")
public class ProductDirDaoImpl implements IProductDirDao{

    /** 注入 sqlSessionTemplate. */
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    
    /**
     * 查询所有商品分类
     * @return list商品分类列表
     */
    @Override
    public List<ProductDir> find() {
        return sqlSessionTemplate.getMapper(IProductDirDao.class).find();
    }

    /**
     * 查询所有商品分类的id和名字
     * @return list商品分类列表
     */
    @Override
    public List<ProductDir> findIdAndName() {
        return sqlSessionTemplate.getMapper(IProductDirDao.class).findIdAndName();
    }

}
