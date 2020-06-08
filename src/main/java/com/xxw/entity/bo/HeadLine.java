package com.xxw.entity.bo;

import java.util.Date;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
public class HeadLine {
    private Long lineld;
    private String lineName;
    private String lineLink;
    private String linelmg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;

    public Long getLineld() {
        return lineld;
    }

    public void setLineld(Long lineld) {
        this.lineld = lineld;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineLink() {
        return lineLink;
    }

    public void setLineLink(String lineLink) {
        this.lineLink = lineLink;
    }

    public String getLinelmg() {
        return linelmg;
    }

    public void setLinelmg(String linelmg) {
        this.linelmg = linelmg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
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
}
