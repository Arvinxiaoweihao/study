/*
 * @(#)ProductServiceImpl.java 2017-8-28下午2:03:13
 * shop
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.thunisoft.shop.service.impl;

import com.thunisoft.shop.dao.IProductDao;
import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.query.ProductQuery;
import com.thunisoft.shop.service.IFtpService;
import com.thunisoft.shop.service.IProductService;
import com.thunisoft.shop.utils.StringUtil;
import com.thunisoft.shop.utils.ftppool.FtpClientPool;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * 商品业务处理.
 * @author ljw on 2017-8-28下午2:03:13
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    /** 日志组件. */
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Resource(name="productDao")
    private IProductDao productDao;

    /**注入ftpService*/
    @Resource
    private IFtpService ftpService;

    /**
     * 保存商品.
     * @param product 商品对象
     */
    @Override
    public void save(Product product) {
        Product saveProduct = productDao.save(product);
        if(saveProduct==null){
            logger.error("保存商品失败。");
        }
        logger.info("保存商品成功");
    }
    
    /**
     * 修改商品.
     * @param product 被修改的商品
     */
    @Override
    public void update(Product product){
        productDao.update(product);
    }

    /**
     * 根据id删除商品
     * @param id 要删除的商品的id
     */
    @Override
    public void delete(Long id){
        productDao.delete(id); 
    }

    /**
     * 根据id查找商品.
     * @param id 要查找的商品id
     * @return Product 要查找的商品
     */
    @Override
    public Product getById(Long id){
        return productDao.getById(id);
    }
    
    /**
     * 根据sn查找商品.
     * @param sn 要查找的商品编号
     * @return Product 要查找的商品
     */
    @Override
    public Product getBySn(String sn){
        return productDao.getBySn(sn);
    }

    /**
     * 查询所有商品.
     * @param productQuery 商品查询对象
     * @return list 查询的商品集合
     */
    @Override
    public List<Product> getByQuery(ProductQuery productQuery){
        return productDao.getByQuery(productQuery);
    }
    
    /**
     * 查询所有商品.
     * @return list 查询的商品集合
     */
    @Override
    public List<Product> findNewProducts(){
        return productDao.findNewProducts();
    }

    /**
     * 下载商品图片
     *
     * @param productList  商品集合
     * @param downloadPath    下载目的地
     * @param contextShowPath 上下文展示路径
     * @return void
     **/
    @Override
    public void downProductImage(List<Product> productList, String downloadPath, String contextShowPath) {
        createDirectory(downloadPath);

        for (Product pro : productList) {
            String filePathAndName = pro.getSmallPic();
            String miniFileName = FilenameUtils.getName(filePathAndName);
            String localFilePathAndName = downloadPath + File.separator
                    + miniFileName;
            File file = new File(localFilePathAndName);
            String contextShowFile = contextShowPath + File.separator + miniFileName;
            pro.setSmallPic(contextShowFile);

            FTPClient ftpClient = null;
            try {
                if (!file.exists()) {
                    ftpClient = FtpClientPool.borrowObject();
                    ftpService.downloadFile(filePathAndName, localFilePathAndName, ftpClient);
                }
            } catch (Exception e) {
                logger.error("ftp下载失败");
            }finally {
                try {
                    FtpClientPool.returnObject(ftpClient);
                } catch (Exception e) {
                    logger.error("回收ftp连接失败");
                }
            }
        }

    }

    /**
     * 查询出一个推荐的新品商品
     *
     * @return com.thunisoft.shop.domain.Product
     **/
    @Override
    public Product findRecommendedNewProduct() {
        Date endDate = new Date();
        Date startDate = DateUtils.addDays(endDate,-30);
        Map<String,Date> paramsMap =  new HashMap<String,Date>();
        paramsMap.put("startDate",startDate);
        paramsMap.put("endDate",endDate);
        List<Product> recommendedNewProductList = productDao.getRecommendedNewProductList(paramsMap);
        if(recommendedNewProductList ==null || CollectionUtils.isEmpty(recommendedNewProductList)){
            return null;
        }
        Random random =  new Random();
        int index = random.nextInt(recommendedNewProductList.size());
        return recommendedNewProductList.get(index);
    }

    /**
     * 创建文件目录
     * @param localFilePath
     */
    private void createDirectory(String localFilePath) {
        File file = new File(localFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * where 语句
     * @param productQuery 查询实体
     * @return String
     */
    private String whereSql(ProductQuery productQuery){
        StringBuilder whereSql = new StringBuilder();
        boolean isWhere = true;
        
        Long productDirId = productQuery.getProductDirId();
        if(!productDirId.equals(-1)){
            StringUtil.isWhere(isWhere, whereSql);
            whereSql.append("d.id = #{productQuery.id}");
        }
        
        BigDecimal salePriceStart = productQuery.getSalePriceStart();
        if(salePriceStart != null){
            StringUtil.isWhere(isWhere, whereSql);
            whereSql.append("p.salePrice > #{productQuery.salePriceStart}");
        }
        
        BigDecimal salePriceEnd = productQuery.getSalePriceEnd();
        if(salePriceEnd != null){
            StringUtil.isWhere(isWhere, whereSql);
            whereSql.append("p.salePrice < #{productQuery.salePriceEnd}");
        }
        
         Integer recommended = productQuery.getRecommended();
        if(!recommended.equals(-1)){
            StringUtil.isWhere(isWhere, whereSql);
            whereSql.append("p.recommended = #{productQuery.recommended}");
        }
        
        String seachKey = productQuery.getSeachKey();
        if(StringUtils.isNotBlank(seachKey)){
            StringUtil.isWhere(isWhere, whereSql);
            whereSql.append("p.name like %#{productQuery.id}% or p.sn like %#{productQuery.id}%");
        }
        return whereSql.toString();
    }
    
    
    
}
