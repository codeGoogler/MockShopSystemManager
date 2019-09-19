package com.mock.manager.service;

import com.mock.manager.entry.ShopCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList( ShopCategory ShopCategoryCondition);
}
