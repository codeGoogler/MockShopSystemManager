package com.mock.manager.dao;

import com.mock.manager.entry.ShopCategory;
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
public interface ShopCategoryDao {
    List<ShopCategory> getShopCategoryList(@Param("ShopCategoryCondition")ShopCategory ShopCategoryCondition);
}
