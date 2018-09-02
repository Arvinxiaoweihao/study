package com.thunisoft.shop.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述：商品实体类.
 * 作者： Administrator
 * 时间： 2017年8月27日下午4:08:47
 * 版本： 1.0
 */
public class Product {

    /**
     * ID.
     */
    private Long id;
    /**
     * 商品名.
     */
    private String name;
    /**
     * 编号.
     */
    private String sn;
    /**
     * 产地.
     */
    private String place;
    /**
     * 规格.
     */
    private String model;
    /**
     * 数量.
     */
    private String num;
    /**
     * 商品简介.
     */
    private String intro;
    /**
     * 商品图片.
     */
    private String bigPic;
    /**
     * 商品缩略图.
     */
    private String smallPic;
    /**
     * 推荐状态
     */
    private Integer status;
    /**
     * 是否推荐.
     */
    private Boolean recommended = false;
    /**
     * 成本价.
     */
    private BigDecimal costPrice;
    /**
     * 卖价.
     */
    private BigDecimal salePrice;
    /**
     * 市场价.
     */
    private BigDecimal marketPrice;
    /**
     * 浏览次数.
     */
    private Integer viewTimes = 0;
    /**
     * 上架时间.
     */
    private Date inputTime;
    /**
     * 商品分类.
     */
    private ProductDir productDir;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sn
     */
    public String getSn() {
        return sn;
    }

    /**
     * @param sn the sn to set
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * @return the intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro the intro to set
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * @return the bigPic
     */
    public String getBigPic() {
        return bigPic;
    }

    /**
     * @param bigPic the bigPic to set
     */
    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    /**
     * @return the smallPic
     */
    public String getSmallPic() {
        return smallPic;
    }

    /**
     * @param smallPic the smallPic to set
     */
    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the recommended
     */
    public Boolean getRecommended() {
        return recommended;
    }

    /**
     * @param recommended the recommended to set
     */
    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    /**
     * @return the costPrice
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * @param costPrice the costPrice to set
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return the salePrice
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return the marketPrice
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice the marketPrice to set
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * @return the viewTimes
     */
    public Integer getViewTimes() {
        return viewTimes;
    }

    /**
     * @param viewTimes the viewTimes to set
     */
    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    /**
     * @return the inputTime
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * @param inputTime the inputTime to set
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * @return the productDir
     */
    public ProductDir getProductDir() {
        return productDir;
    }

    /**
     * @param productDir the productDir to set
     */
    public void setProductDir(ProductDir productDir) {
        this.productDir = productDir;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", sn=" + sn
                + ", place=" + place + ", model=" + model + ", num=" + num
                + ", intro=" + intro + ", bigPic=" + bigPic + ", smallPic="
                + smallPic + ", recommended="
                + recommended + ", costPrice=" + costPrice + ", salePrice="
                + salePrice + ", marketPrice=" + marketPrice + ", viewTimes="
                + viewTimes + ", inputTime=" + inputTime + ", productDir="
                + productDir + "]";
    }


}
