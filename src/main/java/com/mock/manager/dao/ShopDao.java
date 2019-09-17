package com.mock.manager.dao;

import com.mock.manager.entry.Shop;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public interface ShopDao {
   /**
    * 插入店铺信息
    * @param shop
    * @return
    */
   int insertShop(Shop shop);

   /**
    * 更新店铺信息
    */
   int updateShop(Shop shop);
}
