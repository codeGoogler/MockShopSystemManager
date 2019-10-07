package com.mock.manager.service.impl;

import com.mock.manager.dao.ShopDao;
import com.mock.manager.dto.ShopResponseExcuttion;
import com.mock.manager.entry.Shop;
import com.mock.manager.enums.ShopStateEnum;
import com.mock.manager.service.ShopService;
import com.mock.manager.utils.FileUtil;
import com.mock.manager.utils.ImageUtil;
import com.mock.manager.utils.ImageUtil2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
@Service
public class ShopServiceImpl implements ShopService {
    public Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    ShopDao shopDao;


    @Override
    @Transactional //开启事务，保证数据库操作的原子性
    public ShopResponseExcuttion insertShop(Shop shop, InputStream shopImgInputstream, String shopImgame) {
        if(shop == null){
            throw  new RuntimeException("添加失败，shop不能为空");
        }

        //这个时候传过来的时候已经是有部分值了
        try {
            shop.setCreateTime(new Date());
            shop.setLastModifyTime(new Date());
            shop.setEnableStatus(1);
            System.out.print("\n 开始插入图片 " +"\n");
            int result =  shopDao.insertShop(shop);
            System.out.print("\nresult:  " + result+"\n");
            if(result>0){
                if(shopImgInputstream != null){
                    try{
                        addShopAwar(shop,shopImgInputstream,shopImgame);
                      int updateShop =   shopDao.updateShop(shop);
                      if(updateShop <= 0 ){
                          throw  new RuntimeException("updateShop error");
                      }
                      // 此处可用于测试 数据操作的原子性
                    }catch (Exception e){
                        e.printStackTrace();
                        throw  new RuntimeException("addShopAwar error");
                    }
                }
            }else{
                throw  new RuntimeException("创建店铺失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException("insertShop error :"+e.getMessage());
        }
        return new ShopResponseExcuttion(ShopStateEnum.CHECK,shop);
    }

    @Override
    public  ShopResponseExcuttion updateShop(Shop shop, InputStream shopImgInputstream, String shopImgame){
        if(shop == null || shop.getShopId() <= 0){
            return new ShopResponseExcuttion(ShopStateEnum.NO_SHOP);
        }
        try {
            // 修改图片，删除重新对model进行赋值
            if(shopImgInputstream != null){
                Shop shopResult = queryShopInfoById(shop.getShopId());
                if(StringUtils.isEmpty(shopResult.getShopName())){
                    FileUtil.deleteFile(shopResult.getShopName());
                }
                addShopAwar(shop,shopImgInputstream,shopImgame);
            }
            //更新图片的信息
            shop.setLastModifyTime(new Date());
            int result =  shopDao.updateShop(shop);
            if(result <= 0){
                return new ShopResponseExcuttion(ShopStateEnum.INTER_ERROR);
            }
            Shop updateModel = shopDao.queryShopInfoById(shop.getShopId());
            return new ShopResponseExcuttion(ShopStateEnum.SUCCESS,updateModel);
        }catch (Exception e){
            throw new RuntimeException("update shop error "+e.getMessage());
        }
    }


    @Transactional
    public ShopResponseExcuttion insertShop2(Shop shop, InputStream shopImgInputstream, String shopImgame) {
        if(shop != null){
            throw new RuntimeException("输入内容不得为空");
        }
        try {
            shop.setLastModifyTime(new Date());
            shop.setCreateTime(new Date());
            shop.setEnableStatus(-1);
            addShopAwar(shop,shopImgInputstream,shopImgame);

            int result = shopDao.insertShop(shop);
            if(result <= 0){
                throw new RuntimeException("创建店铺失败");
            }
        }catch (Exception e){
            throw new RuntimeException("insertShop error");
        }
        return new ShopResponseExcuttion(ShopStateEnum.CHECK);
    }

    @Override
    public Shop queryShopInfoById(Integer shopId) {
        return shopDao.queryShopInfoById(shopId);
    }

    private void addShopAwar(Shop shop,InputStream shopImgInputstream, String shopImgFileName) {
        //获取shop图片的相对路径
        String  dest = FileUtil.getShopImagePath(shop.getShopId());
        logger.info("图片的相对路径："+dest);
        System.out.print("图片的相对路径："+dest);
        String shopImageAddr = ImageUtil2.generateThumbnail(shopImgInputstream,shopImgFileName,dest);
        //更改img的字段
        shop.setShopImg(shopImageAddr);
        logger.info("最终图片的路径："+dest);
        System.out.print("最终图片的路径："+dest);
    }



}
