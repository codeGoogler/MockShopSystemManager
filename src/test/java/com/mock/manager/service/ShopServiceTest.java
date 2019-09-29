package com.mock.manager.service;

import com.mock.manager.BaseTest;
import com.mock.manager.controller.ShopController;
import com.mock.manager.dto.ShopResponseExcuttion;
import com.mock.manager.entry.Area;
import com.mock.manager.entry.PersonInfo;
import com.mock.manager.entry.Shop;
import com.mock.manager.entry.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：11/9/2019</br> 修改备注：</br>
 */
public class ShopServiceTest extends BaseTest {


    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopController shopController;




    @Test
    @Ignore
    public void addShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(2l);

        Area areas = new Area();
        areas.setAreaId(1);

        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1l);

        shop.setArea(areas);
        shop.setOwner(personInfo);
        shop.setShopCategory(shopCategory);

        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setLastModifyTime(new Date());
        shop.setLatitude(12.45);
        shop.setLongitude(12.45);
        shop.setPhone(String.valueOf(13011007869l));
        shop.setAdvice("test");
        shop.setPriority(1);
        shop.setShopAddr("北京市周口市xxx");
        shop.setShopDesc("兰州拉面欢迎你");
        shop.setShopId(1);
        shop.setShopImg("http:123");
        shop.setShopName("test11111");
        ShopResponseExcuttion insertShop = shopService.insertShop(shop, new FileInputStream("J:\\springCloud\\dest.jpeg"),"J:\\springCloud\\dest.jpeg");
        System.out.print(insertShop.getState());
        logger.info("修改成功！");
    }

    @Test
    @Ignore
    public void addShop2(){
        Shop shop = new Shop();

        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(2l);

        Area areas = new Area();
        areas.setAreaId(1);

        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1l);

        shop.setArea(areas);
        shop.setOwner(personInfo);
        shop.setShopCategory(shopCategory);

        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setLastModifyTime(new Date());
        shop.setLatitude(12.45);
        shop.setLongitude(12.45);
        shop.setPhone(String.valueOf(13011007869l));
        shop.setAdvice("test");
        shop.setPriority(1);
        shop.setShopAddr("北京市周口市xxx");
        shop.setShopDesc("兰州拉面欢迎你");
        shop.setShopId(1);
        shop.setShopImg("http:2222");
        shop.setShopName("test222");
        ShopResponseExcuttion insertShop = null;
        try {
            insertShop = shopService.insertShop(shop, new FileInputStream("J:\\springCloud\\dest.jpeg"),"J:\\springCloud\\dest.jpeg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(insertShop.getState());
        logger.info("添加成功！");
    }
    @Test
    public void getShopInitInfo(){

        HashMap<String,Object> shopInitInfo = shopController.getShopInitInfo();
        System.out.print(shopInitInfo.values());
    }
}
