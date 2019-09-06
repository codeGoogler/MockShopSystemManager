package com.mock.manager.entry;

import java.util.Date;

/**
 * 类功能描述：</br>
 * 本地張浩
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/6</br> 修改备注：</br>
 */
public class LocalAuth extends BaseBean<BaseBean> {
    private Long localAuthId;
    private String userName ;
    private String password;
    private Date createTime;
    private Date lasetModifyTime;
    private PersionInfo persionInfo;

    public Long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLasetModifyTime() {
        return lasetModifyTime;
    }

    public void setLasetModifyTime(Date lasetModifyTime) {
        this.lasetModifyTime = lasetModifyTime;
    }

    public PersionInfo getPersionInfo() {
        return persionInfo;
    }

    public void setPersionInfo(PersionInfo persionInfo) {
        this.persionInfo = persionInfo;
    }

    @Override
    public BaseBean parseModel(String obj) {
        return null;
    }
}
