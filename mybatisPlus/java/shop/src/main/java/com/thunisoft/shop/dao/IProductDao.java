package com.thunisoft.shop.dao;

import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.query.ProductQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述： 商品数据库操作.
 * 作者： Administrator
 * 时间： 2017年8月28日下午8:39:08
 * 版本： 1.0
 */
public interface IProductDao {

    /**
     * 保存商品.
     * @param product 商品
     * @return product 保存后的商品
     */
    public Product save(Product product);

    /**
     * 修改商品.
     * @param product 被修改的商品
     */
    public void update(Product product);

    /**
     * 根据id删除商品
     * @param id 要删除的商品的id
     */
    @Delete("delete from t_product where id=#{id}")
    public void delete(Long id);

    /**
     * 根据id查找商品.
     * @param id 要查找的商品id
     * @return Product 要查找的商品
     */
    public Product getById(Long id);
    
    /**
     * 根据sn查找商品.
     * @param sn 要查找的商品编号
     * @return Product 要查找的商品
     */
    public Product getBySn(String sn);

    /**
     * 查询所有商品.
     * @param productQuery 查询实体
     * @return list 查询的商品集合
     */
    public List<Product> getByQuery(ProductQuery productQuery);
    
    /**
     * 查询所有商品.
     * @return list 查询的商品集合
     */
    public List<Product> findNewProducts();

    /**
     * 查询推荐的新品商品
     * @param paramsMap 查询时间集合
     * @return java.util.List<com.thunisoft.shop.domain.Product>
     **/
    List<Product> getRecommendedNewProductList(Map<String,Date> paramsMap);
}
