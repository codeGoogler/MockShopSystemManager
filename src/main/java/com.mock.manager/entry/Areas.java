package com.mock.manager.entry;

/**
 * 类功能描述：</br>
 * 地区的五个成员变量
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/5</br> 修改备注：</br>
 */
public class Areas extends BaseBean<Areas>{

    //地区id
    private Integer areadId;

    //地区名字
    private String areaName;

    //权重
    private Integer propertity;

    // 创建时间
    private String createTime;

    //更改时间
    private String lastModifyTime;


    @Override
    public Areas parseModel(String obj) {
        return null;
    }
}
