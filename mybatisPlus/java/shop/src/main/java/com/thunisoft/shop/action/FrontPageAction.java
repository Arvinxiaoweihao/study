package com.thunisoft.shop.action;

import com.github.pagehelper.PageHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.ProductDir;
import com.thunisoft.shop.service.IProductDirService;
import com.thunisoft.shop.service.IProductService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 首页控制类
 * @Author ljw
 * @Date 2018/7/3 9:34
 * @Version 1.0
 **/
public class FrontPageAction extends ActionSupport {

    /** 日志组件. */
    private static final Logger logger = LoggerFactory
            .getLogger(FrontPageAction.class);

    /**新品展示数量*/
    private static final Integer NEW_PRODUCT_NUM = 8;

    /**注入productDirService*/
    @Resource
    private IProductDirService productDirService;

    /**注入productService*/
    @Resource
    private IProductService productService;




    /**
     * 前台首页导向.
     * @return String 结果名字
     */
    @Override
    public String execute() throws Exception {
        List<Product> productList = new ArrayList<Product>();

        //玉品类别
        List<ProductDir> productDirList = productDirService.find();

        //华氏新品
        PageHelper.startPage(0, 8);
        List<Product> newProductList = productService.findNewProducts();

        String download = "/resource/download";
        String downloadPath = ServletActionContext.getServletContext().getRealPath(download);
        String contextShowPath = ServletActionContext.getRequest().getContextPath() + File.separator + download;
        if(newProductList != null && CollectionUtils.isNotEmpty(newProductList)){
            productList.addAll(newProductList);
        }

        //新品推荐
        Product recommendedNewProduct = productService.findRecommendedNewProduct();
        if(recommendedNewProduct != null){
            productList.add(recommendedNewProduct);
        }
        
        //开发阶段不连接ftp
//        productService.downProductImage(productList,downloadPath,contextShowPath);

        //action上下文中的map集合，取Map中加上#
        ActionContext.getContext().put("productDirList",productDirList);
        ActionContext.getContext().put("newProductList",newProductList);
        ActionContext.getContext().put("recommendedNewProduct",recommendedNewProduct);


        return ActionSupport.SUCCESS;
    }

}
