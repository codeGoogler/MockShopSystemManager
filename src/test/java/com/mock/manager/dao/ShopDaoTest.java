package com.mock.manager.dao;

import com.mock.manager.BaseTest;
import com.mock.manager.entry.Area;
import com.mock.manager.entry.PersonInfo;
import com.mock.manager.entry.Shop;
import com.mock.manager.entry.ShopCategory;
import org.junit.Ignore;
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
public class ShopDaoTest extends BaseTest {
    @Autowired
    ShopDao shopDao;

    @Test
    @Ignore
    public void insert(){
        Shop shop = new Shop();

        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(2l);

        Area areas = new Area();
        areas.setAreaId(2);

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
        shop.setAdvice("加强训练1");
        shop.setPriority(1);
        shop.setShopAddr("北京市昌平区纷享水底捞");
        shop.setShopDesc("兰州拉面欢迎你");
        shop.setShopId(1);
        shop.setShopImg("http:123");
        shop.setShopName("纷享水底捞");
        shopDao.insertShop(shop);
        logger.info("添加成功！");
    }

    @Test
    @Ignore
    public void update(){
        Shop shop = new Shop();
        shop.setShopId(1);
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
        shop.setAdvice("加强训练1");
        shop.setPriority(1);
        shop.setShopAddr("北京市周口市xxx");
        shop.setShopDesc("兰州拉面欢迎你");
        shop.setShopId(1);
        shop.setShopImg("http:123");
        shop.setShopName("纷享水底捞：已修改");
        shopDao.updateShop(shop);
        logger.info("修改成功！");
    }
    @Test
    @Ignore
    public void update2(){
        Shop shop = new Shop();

        shopDao.updateShop(shop);
        logger.info("修改成功！");
    }
    @Test
    @Ignore
    public void queryShopInfoById(){
        Shop shop =  shopDao.queryShopInfoById(1);

        System.out.print("\n"+"id:"+shop.getShopId()+"\n"+
                "店铺名称:"+shop.getShopName()+"\n"+
                "地区名称:"+shop.getArea().getAreaName()+"\n"+
                "商品名称:"+shop.getShopCategory().getShopCategoryName()+"\n");
    }
    @Test
    public void getShopList(){
        Shop shop =  new Shop();
        shop.setShopName("qer");
        List<Shop> shopList =  shopDao.getShopList(shop,5,4);
        int  totleCouint =  shopDao.queryTotleCount(shop);

        System.out.print(
                "\n"+"总个数:"+shopList.size()+"\n"+
                "\n"+"总个数:"+totleCouint+"\n");

        System.out.println();
        if(!shopList.isEmpty()){
            for (Shop shop1: shopList){
                System.out.println(shop1.toString());
            }
        }

    }
}
