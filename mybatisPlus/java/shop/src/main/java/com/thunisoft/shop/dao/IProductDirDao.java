/*
 * @(#)IProductDirService.java 2017-9-25下午5:40:58
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.thunisoft.shop.domain.ProductDir;

/**
 * 商品分类数据库操作.
 * @author ljw on 2017-9-25下午5:40:58
 */
public interface IProductDirDao {
    
    /**
     * 查询所有商品分类
     * @return list商品分类列表
     */
    @Select("SELECT * FROM t_productdir")
    public List<ProductDir> find();
    
    /**
     * 查询所有商品分类的id和名字
     * @return list商品分类列表
     */
    @Select("SELECT id,name FROM t_productdir")
    public List<ProductDir> findIdAndName();

}
