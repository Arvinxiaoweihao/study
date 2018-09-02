package com.thunisoft.shop.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thunisoft.shop.domain.GoodsItem;
import com.thunisoft.shop.domain.Product;
import com.thunisoft.shop.domain.ProductDir;
import com.thunisoft.shop.domain.ShoppingCart;
import com.thunisoft.shop.domain.query.PageQuery;
import com.thunisoft.shop.domain.query.ProductQuery;
import com.thunisoft.shop.service.IProductDirService;
import com.thunisoft.shop.service.IProductService;
import com.thunisoft.shop.utils.Global;

/**  
 * 华氏超市控制类
 * @author Administrator 
 * @date 2018年7月15日 下午3:40:22 
 * @version v1.0
 */
public class SuperMarketAction extends ActionSupport{

    /**序列化*/
    private static final long serialVersionUID = 1808755118827492751L;
    
    /**注入productDirService*/
    @Resource
    private IProductDirService productDirService;
    
    /**注入productService*/
    @Resource
    private IProductService productService;
    
    /**页面查询参数*/
    private ProductQuery productQuery = new ProductQuery();
    
    /**购买数量*/
    private Integer goodsNum;
    
    /**商品编号*/
    private String goodsSn;
    
    /**ajax返回结果*/
    private String result = "添加成功";
    

    /** 
     * 默认跳转
     */
    @Override
    public String execute() throws Exception {
      //玉品类别
        List<ProductDir> productDirList = productDirService.find();
        
        PageQuery pageQuery = productQuery.getPageQuery();
        Integer currentPage = pageQuery.getCurrentPage();
        Integer pageSize = pageQuery.getPageSize();
        
        PageHelper.startPage(currentPage-1, pageSize);
        List<Product> productList = productService.getByQuery(productQuery);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        //获取总记录数
        Long total = pageInfo.getTotal();
        pageQuery.setCurrentValue(currentPage, pageSize, total.intValue());

        String download = "/resource/download";
        String downloadPath = ServletActionContext.getServletContext().getRealPath(download);
        String contextShowPath = ServletActionContext.getRequest().getContextPath() + File.separator + download;
        
      //开发阶段不连接ftp
//        productService.downProductImage(productList,downloadPath,contextShowPath);


        ActionContext.getContext().put("productList", productList);
        
        ActionContext.getContext().put("productDirList", productDirList);
        return ActionSupport.SUCCESS;
    }
    
    /**
     * 添加商品到购物车
     * @return
     * @throws Exception
     */
    public String addGoods() throws Exception {
        GoodsItem goodsItem = new GoodsItem(goodsSn, goodsNum);
        Product product = productService.getBySn(goodsSn);
        goodsItem.setGoodsName(product.getName());
        goodsItem.setGoodsSalePrice(product.getSalePrice());
        goodsItem.setGoodsNum(goodsNum);
        
        
        HttpSession session = ServletActionContext.getRequest().getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(Global.SHOPPINGCART_IN_SESSION);
        if(shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.addGoodsToCart(goodsItem);
        session.setAttribute(Global.SHOPPINGCART_IN_SESSION, shoppingCart);
        result = "添加成功";
        return "ajaxRequest";
    }
    
    /**
     * 修改商品数量
     * @return
     * @throws Exception
     */
    public String updateGoods() throws Exception {
        GoodsItem goodsItem = new GoodsItem(goodsSn, goodsNum);
        
        HttpSession session = ServletActionContext.getRequest().getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(Global.SHOPPINGCART_IN_SESSION);
        
        shoppingCart.updateGoods(goodsItem);
        session.setAttribute(Global.SHOPPINGCART_IN_SESSION, shoppingCart);
        result = shoppingCart.getTotalPrice().toString();
        return "ajaxRequest";
    }
    
    /**
     * 删除商品
     * @return
     * @throws Exception
     */
    public String deleteGoods() throws Exception {
        
        HttpSession session = ServletActionContext.getRequest().getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(Global.SHOPPINGCART_IN_SESSION);
        
        shoppingCart.deleteGoodsFromCart(goodsSn);
        session.setAttribute(Global.SHOPPINGCART_IN_SESSION, shoppingCart);
        result = shoppingCart.getTotalPrice().toString();
        return "ajaxRequest";
    }

    //===================前台往后台传值====================
    public void setProductQuery(ProductQuery productQuery) {
        this.productQuery = productQuery;
    }
    
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn.trim();
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    //===================后台往前台传值====================
    public ProductQuery getProductQuery() {
        return productQuery;
    }

    public String getResult() {
        return result;
    }


    
}
