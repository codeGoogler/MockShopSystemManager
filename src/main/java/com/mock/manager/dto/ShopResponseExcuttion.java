package com.mock.manager.dto;

import com.mock.manager.entry.BaseBean;
import com.mock.manager.entry.Shop;
import com.mock.manager.enums.ShopStateEnum;

import java.util.List;

/**
 * 类功能描述：</br>
 * 数据传输对象，这个概念来源于J2EE的设计模式，原来的目的是为了EJB的分布式应用提供粗粒度的数据实体，以减少分布式调用的次数，
 * 从而提高分布式调用的性能和降低网络负载，但在这里，我泛指用于展示层与服务层之间的数据传输对象。
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public class ShopResponseExcuttion extends BaseBean<ShopResponseExcuttion> {
    /**
     * 返回的结果状态
     */
    private int state;

    /**
     * 返回的结果信息描素
     */
    private String stateInfo;

    /**
     * 相应处理的数量
     */
    private int count;

    /**
     * 当前操作的shop实体类
     * 比如，增删改时候所处理的实体类
     */
    private Shop shop;

    /**
     * 当前查询的shop实体类
     */
    private List<Shop> shopList;

    @Override
    public ShopResponseExcuttion parseModel(String obj) {
        return null;
    }

    /**
     *  增伤改操作失败时返回一个实体类
     * @param shopStateEnum
     */
    public ShopResponseExcuttion(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    /**
     *查询单条时返回一个实体类
     *
     * @param shopStateEnum
     * @param shop
     */
    public ShopResponseExcuttion(ShopStateEnum shopStateEnum,Shop shop) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }
    /**
     *查询多条时返回一个实体类
     *
     * @param shopStateEnum
     * @param shopList
     */
    public ShopResponseExcuttion(ShopStateEnum shopStateEnum,List<Shop> shopList) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }
    public ShopResponseExcuttion() {

    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }
}
