package com.thunisoft.shop.domain;

/**
 * 描述： 商品分类
 * 作者： Administrator
 * 时间： 2017年8月27日下午5:35:34
 * 版本： 1.0
 */
public class ProductDir {

    /** Id. */
    private Long id;

    /** 分类名. */
    private String name;

    /** 分类的英语名. */
    private String englishName;

    /** 简介. */
    private String intro;

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
     * @return the englishName
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @param englishName the englishName to set
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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

    /** (non-Javadoc)
     */
    @Override
    public String toString() {
        return "ProductDir [id=" + id + ", name=" + name + ", englishName="
                + englishName + ", intro=" + intro + "]";
    }

}
