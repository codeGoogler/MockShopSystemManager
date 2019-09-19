package com.mock.manager.service.impl;

import com.mock.manager.dao.ShopCategoryDao;
import com.mock.manager.entry.ShopCategory;
import com.mock.manager.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
public class ShopCategoryImpl implements ShopCategoryService {
    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory ShopCategoryCondition) {

        return shopCategoryDao.getShopCategoryList(ShopCategoryCondition);
    }
}
