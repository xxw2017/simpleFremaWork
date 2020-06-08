package com.xxw.service.solo.impl;

import com.xxw.entity.bo.HeadLine;
import com.xxw.entity.dto.Result;
import com.xxw.service.solo.HeadLineService;
import simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineld) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineByld(int headLineld) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pagelndex, int pageSize) {
        return null;
    }
}
