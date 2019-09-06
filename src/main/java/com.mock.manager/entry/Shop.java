package com.mock.manager.entry;

import java.awt.geom.Area;
import java.util.Date;

/**
 * 类功能描述：</br>
 * 电偶实体类信息
 * @author yuyahao
 * @version 1.0 </p> 修改时间：6/9/2019</br> 修改备注：</br>
 */
public class Shop {
    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Date createTime;
    private Date lastModifyTime;
    // -1 不可用 0 审核中 1可用
    private Integer enableStatus;
    // 超级管理员给店家 的提醒
    private String advice;
    private Area area;
    private PersionInfo owner;
    //店铺类别 实体类
    private ShopCategory shopCategory;
}
