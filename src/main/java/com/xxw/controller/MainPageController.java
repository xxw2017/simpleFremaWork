package com.xxw.controller;

import com.xxw.entity.dto.MainPagelnfoDTO;
import com.xxw.entity.dto.Result;
import com.xxw.service.combine.HeadLineShopCategoryCombineService;
import simpleframework.core.annotation.Controller;
import simpleframework.inject.annotation.AutoWired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiongxianwei
 * 2020/6/8 0008
 */
@Controller
public class MainPageController {
    @AutoWired(value = "HeadLineShopCategoryCombineServiceImpl2")
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    //test
    public HeadLineShopCategoryCombineService getHeadLineShopCategoryCombineService() {
        return headLineShopCategoryCombineService;
    }

    public Result<MainPagelnfoDTO> getMainPageInfo(HttpServletRequest request, HttpServletResponse response){
        return headLineShopCategoryCombineService.getMainPagelnfo();
    }

}
