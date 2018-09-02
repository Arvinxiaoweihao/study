/*
 * @(#)IProductService.java 2017-8-28下午2:02:39
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.service;

import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.query.ProductQuery;

import java.util.List;

/**
 * 商品业务处理.
 * @author ljw on 2017-8-28下午2:02:39
 */
public interface IProductService {
    
    /**
     * 保存商品.
     * @param product
     */
    public void save(Product product);

    /**
     * 修改商品.
     * @param product 被修改的商品
     */
    public void update(Product product);

    /**
     * 根据id删除商品
     * @param id 要删除的商品的id
     */
    public void delete(Long id);

    /**
     * 根据id查找商品.
     * @param productSn 要查找的商品id
     * @return Product 要查找的商品
     */
    public Product getById(Long productSn);
    
    /**
     * 根据sn查找商品.
     * @param sn 要查找的商品编号
     * @return Product 要查找的商品
     */
    public Product getBySn(String sn);

    /**
     * 查询所有商品.
     * @param productQuery 商品查询对象
     * @return list 查询的商品集合
     */
    public List<Product> getByQuery(ProductQuery productQuery);
    
    /**
     * 查询所有商品.
     * @return list 查询的商品集合
     */
    public List<Product> findNewProducts();

    /**
     * 下载商品图片
     * @param productList 商品集合
     * @param downloadPath 下载目的地
     * @param contextShowPath 上下文展示路径
     * @return void
     **/
    void downProductImage(List<Product> productList, String downloadPath, String contextShowPath);


    /**
     * 查询出一个推荐的新品商品
     * @return com.thunisoft.shop.domain.Product
     **/
    Product findRecommendedNewProduct();
}
