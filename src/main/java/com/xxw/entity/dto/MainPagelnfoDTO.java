package com.xxw.entity.dto;

import com.xxw.entity.bo.HeadLine;
import com.xxw.entity.bo.ShopCategory;

import java.util.List;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
public class MainPagelnfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;

    public List<HeadLine> getHeadLineList() {
        return headLineList;
    }

    public void setHeadLineList(List<HeadLine> headLineList) {
        this.headLineList = headLineList;
    }

    public List<ShopCategory> getShopCategoryList() {
        return shopCategoryList;
    }

    public void setShopCategoryList(List<ShopCategory> shopCategoryList) {
        this.shopCategoryList = shopCategoryList;
    }
}
