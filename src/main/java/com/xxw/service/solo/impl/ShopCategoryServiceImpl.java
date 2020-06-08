package com.xxw.service.solo.impl;

import com.xxw.entity.bo.ShopCategory;
import com.xxw.entity.dto.Result;
import com.xxw.service.solo.ShopCategoryService;
import simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryld) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryByld(int shopCategoryld) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
