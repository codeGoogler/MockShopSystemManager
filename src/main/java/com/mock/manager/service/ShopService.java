package com.mock.manager.service;

import com.mock.manager.dto.ShopResponseExcuttion;
import com.mock.manager.entry.Shop;

import java.io.File;
import java.io.InputStream;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public interface ShopService {
    /**
     * 插入店铺信息
     * @param shop
     * @return
     */
//    int insertShop(Shop shop);
    ShopResponseExcuttion insertShop(Shop shop, InputStream shopImgInputstream,String name);

    /**
     * 更新店铺信息
     */
    int updateShop(Shop shop);


    ShopResponseExcuttion insertShop2(Shop shop, InputStream shopImgInputstream, String shopImgame);
}
