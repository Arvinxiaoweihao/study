/*
 * @(#)IProductDirService.java 2017-9-25下午5:40:58
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.service;

import java.util.List;

import com.thunisoft.shop.domain.ProductDir;

/**
 * 商品分类业务处理.
 * @author ljw on 2017-9-25下午5:40:58
 */
public interface IProductDirService {
    
    /**
     * 查询所有商品分类
     * @return list商品分类列表
     */
    public List<ProductDir> find();
    
    /**
     * 查询所有商品分类的id和名字
     * @return list商品分类列表
     */
    public List<ProductDir> findIdAndName();
    

}
