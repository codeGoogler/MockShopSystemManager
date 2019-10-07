package com.mock.manager.entry;

/**
 * 类功能描述：</br>
 * 地区的五个成员变量
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/5</br> 修改备注：</br>
 */
public class Area extends BaseBean<Area>{

    //地区id
    private int areaId;

    //地区名字
    private String areaName;

    //权重
    private Integer priority;

    // 创建时间
    private String createTime;

    //更改时间
    private String lastModifyTime;


    @Override
    public  Area parseModel(String obj) {
        return null;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer propertity) {
        this.priority = propertity;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public String toString() {
        return areaId+"   "+areaName;
    }
}
