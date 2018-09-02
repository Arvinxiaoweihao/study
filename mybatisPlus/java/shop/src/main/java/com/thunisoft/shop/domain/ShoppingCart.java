package com.thunisoft.shop.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**  
 *  购物车 
 * @author Administrator 
 * @date 2018年7月15日 下午7:18:15 
 * @version v1.0
 */
public class ShoppingCart {

    /**购物车中商品*/
    private Map<String,GoodsItem> goodsMap = new HashMap<String,GoodsItem>();
    
    /**总价值*/
    private BigDecimal totalPrice = new BigDecimal(0);
    
    /**
     * 向购物车中加入商品
     * @param goodsItem 商品
     */
    public void addGoodsToCart(GoodsItem goodsItem){
        String sn = goodsItem.getGoodsSn();
        GoodsItem item = goodsMap.get(sn);
        if(item == null){
            goodsMap.put(sn,goodsItem);
        }else{
            goodsItem.setGoodsNum(goodsItem.getGoodsNum()+item.getGoodsNum());
            goodsMap.put(sn,goodsItem);
        }
        totalPrice = totalPrice.add(goodsItem.getGoodsSalePrice().multiply(new BigDecimal(goodsItem.getGoodsNum())));
    }
    
    /**
     * 修改商品数量
     * @param goodsItem
     */
    public void updateGoods(GoodsItem goodsItem) {
        String sn = goodsItem.getGoodsSn();
        Integer newNum = goodsItem.getGoodsNum();
        
        GoodsItem item = goodsMap.get(sn);
        Integer oldNum = item.getGoodsNum();
        if(newNum>oldNum){
            totalPrice = totalPrice.add(item.getGoodsSalePrice().multiply(new BigDecimal(newNum-oldNum)));
        }else{
            totalPrice = totalPrice.subtract(item.getGoodsSalePrice().multiply(new BigDecimal(oldNum-newNum)));
        }
        item.setGoodsNum(newNum);
    }
    
    /**
     * 移除购物车中商品
     * @param sn 商品编号
     */
    public void deleteGoodsFromCart(String sn){
        GoodsItem item = goodsMap.get(sn);
        totalPrice = totalPrice.subtract(item.getGoodsSalePrice().multiply(new BigDecimal(item.getGoodsNum())));
        goodsMap.remove(sn);
    }

    /**
     * @return goodsMap
     */
    public Map<String, GoodsItem> getGoodsMap() {
        return goodsMap;
    }

    /**
     * @param goodsMap
     */
    public void setGoodsMap(Map<String, GoodsItem> goodsMap) {
        this.goodsMap = goodsMap;
    }

    /**
     * @return totalPrice
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ShoppingCart [goodsMap=" + goodsMap + ", totalPrice="
                + totalPrice + "]";
    }

    
    
    
    
}
