package com.thunisoft.shop.domain.query;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @version v1.0
 * @Description: 商品查询条件对象
 * @date 2018年6月6日 下午11:20:57
 */
public class ProductQuery {

    /**
     * 商品分类id
     */
    private Long productDirId = -1L;
    /**
     * 商品销售价.
     */
    private BigDecimal salePriceStart;
    /**
     * 商品销售价.
     */
    private BigDecimal salePriceEnd;
    /**
     * 是否推荐.<br/>
     * -1.请选择<br/>
     * 0.不推荐<br/>
     * 1.推荐
     */
    private Integer recommended = -1;
    /**
     * 关键字
     */
    private String seachKey;
    /**
     * 展示高级查询<br/>
     * 0.不展示<br/>
     * 1.展示
     */
    private Integer showMoreQuery = 0;
    
    /**
     * 分页对象
     */
    private PageQuery pageQuery = new PageQuery();


    /**
     * @return the productDirId
     */
    public Long getProductDirId() {
        return productDirId;
    }

    /**
     * @param productDirId the productDirId to set
     */
    public void setProductDirId(Long productDirId) {
        this.productDirId = productDirId;
    }

    public BigDecimal getSalePriceStart() {
        return salePriceStart;
    }

    public void setSalePriceStart(BigDecimal salePriceStart) {
        this.salePriceStart = salePriceStart;
    }

    public BigDecimal getSalePriceEnd() {
        return salePriceEnd;
    }

    public void setSalePriceEnd(BigDecimal salePriceEnd) {
        this.salePriceEnd = salePriceEnd;
    }


    /**
     * @return the recommended
     */
    public Integer getRecommended() {
        return recommended;
    }

    /**
     * @param recommended the recommended to set
     */
    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    /**
     * @return the showMoreQuery
     */
    public Integer getShowMoreQuery() {
        return showMoreQuery;
    }

    /**
     * @param showMoreQuery the showMoreQuery to set
     */
    public void setShowMoreQuery(Integer showMoreQuery) {
        this.showMoreQuery = showMoreQuery;
    }

    /**
     * @return the seachKey
     */
    public String getSeachKey() {
        return seachKey;
    }

    /**
     * @param seachKey the seachKey to set
     */
    public void setSeachKey(String seachKey) {
        this.seachKey = seachKey;
    }

    /**
     * @return pageQuery
     */
    public PageQuery getPageQuery() {
        return pageQuery;
    }

    /**
     * @param pageQuery
     */
    public void setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }

    /** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProductQuery [productDirId=" + productDirId
                + ", salePriceStart=" + salePriceStart + ", salePriceEnd="
                + salePriceEnd + ", recommended=" + recommended + ", seachKey="
                + seachKey + ", showMoreQuery=" + showMoreQuery + ", pageQuery="
                + pageQuery + "]";
    }


}
