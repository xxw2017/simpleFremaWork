package com.xxw.service.solo;

import com.xxw.entity.bo.HeadLine;
import com.xxw.entity.dto.Result;

import java.util.List;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(int headLineld);
    Result<Boolean> modifyHeadLine(HeadLine headLine);
    Result<HeadLine> queryHeadLineByld(int headLineld);
    Result<List<HeadLine>>queryHeadLine(HeadLine headLineCondition, int pagelndex, int pageSize);
}
