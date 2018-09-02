package com.thunisoft.shop.domain;

import java.math.BigDecimal;

/**  
 * 购物车 中商品信息
 * @author Administrator 
 * @date 2018年7月15日 下午6:28:52 
 * @version v1.0
 */
public class GoodsItem {

    /**商品编号*/
    private String goodsSn;
    
    /**商品名字*/
    private String goodsName;
    
    /**购买数量*/
    private Integer goodsNum;
    
    /**商品售价*/
    private BigDecimal goodsSalePrice;
    
    /**
     * 无参构造器
     */
    public GoodsItem() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 带参构造器
     * @param goodsSn 商品编号
     * @param goodsNum 购买数量
     */
    public GoodsItem(String goodsSn, Integer goodsNum) {
        super();
        this.goodsSn = goodsSn;
        this.goodsNum = goodsNum;
    }



    /**
     * @return goodsSn
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * @param goodsSn
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn.trim();
    }

    /**
     * @return goodsName
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * @return goodsNum
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * @param goodsNum
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * @return goodsSalePrice
     */
    public BigDecimal getGoodsSalePrice() {
        return goodsSalePrice;
    }

    /**
     * @param goodsSalePrice
     */
    public void setGoodsSalePrice(BigDecimal goodsSalePrice) {
        this.goodsSalePrice = goodsSalePrice;
    }

    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GoodsItem [goodsSn=" + goodsSn + ", goodsName=" + goodsName
                + ", goodsNum=" + goodsNum + ", goodsSalePrice="
                + goodsSalePrice + "]";
    }

    
}
