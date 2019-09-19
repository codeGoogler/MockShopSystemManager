package com.mock.manager.enums;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public enum ShopStateEnum {
    CHECK(0,"未审核"),
    OFFLINE(-1,"不合格店铺"),
    SUCCESS(1,"操作成功"),
    VERTIFY(2,"审核通过"),
    INTER_ERROR(1001,"内部系统错误"),
    NO_SHOP(1002,"shop为空");


    private int state;
    private String stateInfo;


    ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum stateOf(int state){
        for (ShopStateEnum shopStateEnum:values()) {
            if(shopStateEnum.getState() == state){
                return shopStateEnum;
            }
        }
        return  null;
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
}
