package com.xxw.service.solo;

import com.xxw.entity.bo.ShopCategory;
import com.xxw.entity.dto.Result;

import java.util.List;

/**
 * @author xiongxianwei
 * 2020/6/1
 */
public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryld);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategoryByld(int shopCategoryld);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex,int pageSize);
}
