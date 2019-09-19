package com.mock.manager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.manager.dto.ShopResponseExcuttion;
import com.mock.manager.entry.Area;
import com.mock.manager.entry.PersonInfo;
import com.mock.manager.entry.Shop;
import com.mock.manager.entry.ShopCategory;
import com.mock.manager.enums.ShopStateEnum;
import com.mock.manager.service.AreaService;
import com.mock.manager.service.ShopCategoryService;
import com.mock.manager.service.ShopService;
import com.mock.manager.utils.FileUtil;
import com.mock.manager.utils.HttpServletRequestUtils;
import com.mock.manager.utils.ImageUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopCategoryService shopCategoryService;
    @Autowired
    AreaService areaService;

    @RequestMapping(value = "/regisitShop",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> insertShop(HttpServletRequest httpServletRequest){

        HashMap<String,Object> hashMap = new HashMap<>();

        //接收参数， 注册店铺，返回结果
        String shopBody = HttpServletRequestUtils.getString(httpServletRequest,"shopBody");
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        Shop shop = null;
        try {
             shop =  mapper.readValue(shopBody,Shop.class);

        } catch (IOException e) {
            hashMap.put("status",1004);
            hashMap.put("success",false);
            hashMap.put("message","添加店铺失败");
        }

        // 判断图片
        CommonsMultipartFile shopImgFile = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(httpServletRequest.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(httpServletRequest)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
            shopImgFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else {
            hashMap.put("status",1004);
            hashMap.put("success",false);
            hashMap.put("message","图片不能为空");
        }

        if(shop != null && shopImgFile != null){
            PersonInfo personInfo = new PersonInfo();
            personInfo.setUserId(1l);
            shop.setOwner(personInfo);

            File file = new File(FileUtil.getImgBasePath()+ FileUtil.getRandomFileName());
            try {
                mutilpartFileToFile(shopImgFile.getInputStream(),file);
                ShopResponseExcuttion shopResponseExcuttion = shopService.insertShop(shop,file);
                if(shopResponseExcuttion.getState() == ShopStateEnum.CHECK.getState()){
                    hashMap.put("status",200);
                    hashMap.put("success",true);
                    hashMap.put("message","添加店铺成功");
                }else {
                    hashMap.put("status",1004);
                    hashMap.put("success",false);
                    hashMap.put("message","添加店铺失败");
                }
            } catch (IOException e) {
                hashMap.put("status",1004);
                hashMap.put("success",false);
                hashMap.put("message","创建店铺失败"+e.getMessage());
            }
        }else{
            hashMap.put("status",1003);
            hashMap.put("success",false);
            hashMap.put("message","请输入店铺信息");
        }
        return hashMap;
    }

    @RequestMapping(value = "/getShopInitInfo",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,Object> getShopInitInfo(){
        HashMap<String,Object> resultMap = new HashMap<>();
        ShopCategory shopCategoryCondition = new ShopCategory();
        try {
            List<ShopCategory> list = shopCategoryService.getShopCategoryList(shopCategoryCondition);
            List<Area> shopAreaList =  areaService.queryAllArea();
            if(list != null ){
                resultMap.put("status",200);
                resultMap.put("success",true);
                resultMap.put("shopCategoryList",list);
                resultMap.put("shopAreaList",shopAreaList);
                resultMap.put("message",list.size());
            }
        }catch (Exception e){
            resultMap.put("status",1003);
            resultMap.put("success",false);
            resultMap.put("message","服务器查询错误"+e.getMessage());
        }
         return  resultMap;
    }



    private void mutilpartFileToFile(InputStream shopImg, File file){
        FileOutputStream outputStream = null ;
        try {
            outputStream = new FileOutputStream(file);
            int readByte = 0;
            byte [] butter = new byte[1024];
            while ((readByte = shopImg.read(butter)) != -1){
                outputStream.write(readByte);
            }

        } catch (Exception e) {
            throw  new RuntimeException("调用mutilpartFileToFile异常"+e.getMessage());
        }

        try {
            outputStream.close();
            shopImg.close();
        } catch (IOException e) {
            throw  new RuntimeException("调用mutilpartFileToFile异常"+e.getMessage());
        }
    }
}
