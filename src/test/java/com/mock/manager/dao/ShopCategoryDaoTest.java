package com.mock.manager.dao;

import com.mock.manager.BaseTest;
import com.mock.manager.entry.Area;
import com.mock.manager.entry.PersonInfo;
import com.mock.manager.entry.Shop;
import com.mock.manager.entry.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Test
    public void testShopCategoryDao(){
        ShopCategory panent =   new ShopCategory();
        panent.setShopCategoryId(2l);
        ShopCategory shopCategoryCondition =   new ShopCategory();
//        shopCategoryCondition.setParent(panent);
        List<ShopCategory> getShopCategoryList = shopCategoryDao.getShopCategoryList(shopCategoryCondition);
        for (ShopCategory shopCategory:getShopCategoryList ) {
            System.out.print("\n"+shopCategory.getShopCategoryId()+" "+shopCategory.getShopCategoryName()+"\n");
        }
    }

}
