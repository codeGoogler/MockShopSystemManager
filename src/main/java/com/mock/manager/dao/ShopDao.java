package com.mock.manager.dao;

import com.mock.manager.entry.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

   /**
    * 查询店铺的信息
    *
    */
   Shop queryShopInfoById(Integer shopId);
   /**
    * 查询店铺的信息
    *
    */
   int queryTotleCount(@Param("shopContadition") Shop shopContadition);


   /**
    *
    * @param shopContadition  查询所有的店铺信息   店铺名，店铺id,店铺类别，区域iD，和ownerID， 加上@Params进行在映射里面唯一的标识
    * @param pageNo  分页查询的条件
    * @param pageSize  分页查询的条件
    * @return
    */
   List<Shop> getShopList(@Param("shopContadition") Shop shopContadition, @Param("pageNo")int pageNo,@Param("pageSize")int  pageSize);

}
