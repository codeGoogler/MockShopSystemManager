package com.mock.manager.entry;

import java.util.Date;

/**
 * 类功能描述：</br>
 * 头条
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/6</br> 修改备注：</br>
 */
public class HeadLine  extends BaseBean<HeadLine>{
    private Long lineId;
    private  String lineName;
    private String lineLink;
    private String lineImg;
    private  Integer priority;
    //0 不可用 1是可用
    private Integer enableStatus;
    private Date createTime;
    private Date lastModifyTime;

    @Override
    public HeadLine parseModel(String obj) {
        return null;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
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

    public String getLineImg() {
        return lineImg;
    }

    public void setLineImg(String lineImg) {
        this.lineImg = lineImg;
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

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}
