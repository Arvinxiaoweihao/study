package com.thunisoft.shop.dao.impl;

import com.thunisoft.shop.dao.IProductDao;
import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.query.ProductQuery;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述： 商品数据库操作.
 * 作者： Administrator
 * 时间： 2017年8月28日下午8:39:50
 * 版本： 1.0
 */
@Repository("productDao")
public class ProductDaoImpl implements IProductDao {


    /** 注入 sqlSessionTemplate. */
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    
    /** 注入 jdbcTemplate. */
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 保存商品.
     * @param product 商品
     * @return product 保存后的商品
     */
    @Override
    public Product save(Product product) {
        sqlSessionTemplate.insert("com.thunisoft.shop.mapper.ProductMapper.save",
            product);
        return product;
    }
    
    /**
     * 修改商品.
     * @param product 被修改的商品
     */
    @Override
    public void update(Product product){
        sqlSessionTemplate.update(
            "com.thunisoft.shop.mapper.ProductMapper.update", product);
    }

    /**
     * 根据id删除商品
     * @param id 要删除的商品的id
     */
    @Override
    public void delete(Long id){
        sqlSessionTemplate.getMapper(IProductDao.class).delete(id);
    }

    /**
     * 根据id查找商品.
     * @param id 要查找的商品id
     * @return Product 要查找的商品
     */
    @Override
    public Product getById(Long id){
        return sqlSessionTemplate.selectOne(
                "com.thunisoft.shop.mapper.ProductMapper.getById",id);
    }
    
    /**
     * 根据id删除商品
     * @param id 要删除的商品的id
     */
    @Override
    public Product getBySn(String sn){
//         List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_product where sn=?", new Object[]{sn});
//         return (Product) list.get(0);
        return sqlSessionTemplate.selectOne(
            "com.thunisoft.shop.mapper.ProductMapper.getBySn",sn);
    }

    /**
     * 查询所有商品.
     * @param productQuery 查询实体
     * @return list 查询的商品集合
     */
    @Override
    public List<Product> getByQuery(ProductQuery productQuery){
        return sqlSessionTemplate.selectList(
            "com.thunisoft.shop.mapper.ProductMapper.getByQuery",productQuery);
    }
    
    /**
     * 查询所有商品.
     * @return list 查询的商品集合
     */
    @Override
    public List<Product> findNewProducts(){
        return sqlSessionTemplate.selectList(
            "com.thunisoft.shop.mapper.ProductMapper.findNewProducts");
    }

    /**
     * 查询推荐的新品商品
     *
     * @param paramsMap 查询时间集合
     * @return java.util.List<com.thunisoft.shop.domain.Product>
     **/
    @Override
    public List<Product> getRecommendedNewProductList(Map<String, Date> paramsMap) {
        return sqlSessionTemplate.selectList("com.thunisoft.shop.mapper.ProductMapper.getRecommendedNewProducts",paramsMap);
    }

}
