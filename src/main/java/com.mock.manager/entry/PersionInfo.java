package com.mock.manager.entry;

import java.util.Date;

/**
 * 类功能描述：</br>
 * 用戶信息
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/6</br> 修改备注：</br>
 */
public class PersionInfo extends  BaseBean<PersionInfo>{
    private long userId;
    private String name;
    private String avgImg;
    private String email;
    private String gender;
    private Integer enableStatus;

    // 用戶權限
    private Integer userType;
    private Date createTime;
    private Date lastModifyTime;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvgImg() {
        return avgImg;
    }

    public void setAvgImg(String avgImg) {
        this.avgImg = avgImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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

    @Override
    public PersionInfo parseModel(String obj) {
        return null;
    }
}
