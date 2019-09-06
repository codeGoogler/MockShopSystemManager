package com.mock.manager.entry;

import java.util.Date;

/**
 * 类功能描述：</br>
 * 微信的賬號
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/6</br> 修改备注：</br>
 */
public class WebchatAuth extends BaseBean<WebchatAuth> {
    @Override
    public WebchatAuth parseModel(String obj) {
        return null;
    }

    private Long wetchatAithId;
    private String openId;
    private Date createTime;
    private PersionInfo persionInfo;

    public Long getWetchatAithId() {
        return wetchatAithId;
    }

    public void setWetchatAithId(Long wetchatAithId) {
        this.wetchatAithId = wetchatAithId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersionInfo getPersionInfo() {
        return persionInfo;
    }

    public void setPersionInfo(PersionInfo persionInfo) {
        this.persionInfo = persionInfo;
    }
}
