package com.xxw.entity.bo;

import java.util.Date;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
public class ShopCategory {
    private Long shopCategoryld;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategorylmg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;

    public Long getShopCategoryld() {
        return shopCategoryld;
    }

    public void setShopCategoryld(Long shopCategoryld) {
        this.shopCategoryld = shopCategoryld;
    }

    public String getShopCategoryName() {
        return shopCategoryName;
    }

    public void setShopCategoryName(String shopCategoryName) {
        this.shopCategoryName = shopCategoryName;
    }

    public String getShopCategoryDesc() {
        return shopCategoryDesc;
    }

    public void setShopCategoryDesc(String shopCategoryDesc) {
        this.shopCategoryDesc = shopCategoryDesc;
    }

    public String getShopCategorylmg() {
        return shopCategorylmg;
    }

    public void setShopCategorylmg(String shopCategorylmg) {
        this.shopCategorylmg = shopCategorylmg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public ShopCategory getParent() {
        return parent;
    }

    public void setParent(ShopCategory parent) {
        this.parent = parent;
    }
}
