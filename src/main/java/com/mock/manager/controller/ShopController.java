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
import com.mock.manager.utils.VertifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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
@Api(tags = "店铺管理")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopCategoryService shopCategoryService;

    @Autowired
    AreaService areaService;


    @GetMapping(value = "/getShopById")
    @ResponseBody
    @ApiOperation(value = "根据店铺id查询店铺信息",httpMethod = "GET")
    public HashMap<String,Object> getShopById(HttpServletRequest httpServletRequest){
        HashMap<String,Object> hashMap = new HashMap<>();
        // 得到店铺的id
       Integer shopId =  HttpServletRequestUtils.getInt(httpServletRequest,"shopId");
       if(shopId <= 0){
           hashMap.put("status",1003);
           hashMap.put("success",false);
           hashMap.put("message","店铺id传参错误~");
           return hashMap;
       }
       try {
           Shop shop = shopService.queryShopInfoById(shopId);
           System.out.println("店铺秒速L:"+shop.getShopDesc());
           hashMap.put("status",200);
           hashMap.put("success",true);
           hashMap.put("shop",shop == null ? new Shop() : shop);
       }catch (Exception e){
           hashMap.put("status",1004);
           hashMap.put("success",false);
           hashMap.put("message","params is error "+e.getMessage());
        }
        return hashMap;
    }



    @RequestMapping(value = "/updateShop",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "跟新一个店铺",httpMethod = "POST")
    public HashMap<String,Object> updateShop(HttpServletRequest httpServletRequest){
        System.out.print("httpServletRequest: " +httpServletRequest+"\n");
        HashMap<String,Object> hashMap = new HashMap<>();
        if(!VertifyCodeUtils.checkVertifyCode(httpServletRequest)){
            hashMap.put("status",1003);
            hashMap.put("success",false);
            hashMap.put("message","验证码 错误");
            return hashMap;
        }
        //接收参数， 注册店铺，返回结果
        String shopBody = HttpServletRequestUtils.getString(httpServletRequest,"shopBody");

        System.out.print("shopBody: " +shopBody+"\n");
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        Shop shop = null;
        try {
            shop =  mapper.readValue(shopBody,Shop.class);
            System.out.print("shopBody: " +shopBody+"\n");
        } catch (IOException e) {
            hashMap.put("status",1004);
            hashMap.put("success",false);
            hashMap.put("message","添加店铺失败"+e.getMessage());
        }

        // 判断图片
        CommonsMultipartFile shopImgFile = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(httpServletRequest.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(httpServletRequest)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
            shopImgFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }
        System.out.print("shop: " +shop+"   "+shopImgFile+"\n");
         // 修改店铺信息
        if(shop != null && shop.getShopId() < 1){

            try {
                ShopResponseExcuttion shopResponseExcuttion = null;
                if(shopImgFile == null){
                    shopResponseExcuttion = shopService.updateShop(shop, null,"");
                }else{
                    shopResponseExcuttion = shopService.updateShop(shop, shopImgFile.getInputStream(),shopImgFile.getOriginalFilename());
                    System.out.print("用户上传的全路径：  "+shopImgFile.getOriginalFilename()+"    "+shopImgFile.getName()+"\n");
                }
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


    @RequestMapping(value = "/regisitShop",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "增加店铺",httpMethod = "POST")
    public HashMap<String,Object> insertShop(HttpServletRequest httpServletRequest){
        System.out.print("httpServletRequest: " +httpServletRequest+"\n");
        HashMap<String,Object> hashMap = new HashMap<>();
        if(!VertifyCodeUtils.checkVertifyCode(httpServletRequest)){
            hashMap.put("status",1003);
            hashMap.put("success",false);
            hashMap.put("message","验证码 错误");
            return hashMap;
        }
        //接收参数， 注册店铺，返回结果
        String shopBody = HttpServletRequestUtils.getString(httpServletRequest,"shopBody");

        System.out.print("shopBody: " +shopBody+"\n");
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        Shop shop = null;
        try {
            shop =  mapper.readValue(shopBody,Shop.class);
            System.out.print("shopBody: " +shopBody+"\n");
        } catch (IOException e) {
            hashMap.put("status",1004);
            hashMap.put("success",false);
            hashMap.put("message","添加店铺失败"+e.getMessage());
            return hashMap;
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
        System.out.print("shop: " +shop+"   "+shopImgFile+"\n");
        // 注册店铺
        if(shop != null && shopImgFile != null){
//            PersonInfo personInfo = new PersonInfo();
            PersonInfo personInfo = (PersonInfo) httpServletRequest.getSession().getAttribute("user");
            personInfo.setUserId(1l);
            shop.setOwner(personInfo);
            System.out.print("用户上传的全路径：  "+shopImgFile.getOriginalFilename()+"    "+shopImgFile.getName()+"\n");
            try {
                ShopResponseExcuttion shopResponseExcuttion = shopService.insertShop(shop, shopImgFile.getInputStream(),shopImgFile.getOriginalFilename());
                if(shopResponseExcuttion.getState() == ShopStateEnum.CHECK.getState()){
                    // 店铺和用户的关系是一对多的,一个owner可以创建多个店铺，在session里面保存一个店铺类表用来保存操作的店铺为那几个

                     List<Shop> shopList = (List<Shop>) httpServletRequest.getSession().getAttribute("shopList");
                     if(shopList == null || shopList.size() == 0){
                         shopList = new ArrayList<>();
                     }
                    shopList.add(shop);
                    httpServletRequest.getSession().setAttribute("shopList",shopList);
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
    @ApiOperation(value = "得到店铺信息",httpMethod = "GET")
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

                resultMap.put("message",list.size());
            }
        }catch (Exception e){
            resultMap.put("status",1003);
            resultMap.put("success",false);
            resultMap.put("message","服务器查询错误"+e.getMessage());
        }
         return  resultMap;
    }

    //获取当前的店铺管理的信息
    @GetMapping(value = "/getShopManagerInfo")
    @ResponseBody
    @ApiOperation(value = "获取当前的店铺管理的信息",httpMethod = "GET")
    public HashMap<String,Object> getShopManagerInfo(HttpServletRequest httpServletRequest){
        HashMap<String,Object> resultMap = new HashMap<>();
        int  shopId = HttpServletRequestUtils.getInt(httpServletRequest,"shopId");
        if(shopId <= 0){
           Object objShop =  httpServletRequest.getSession().getAttribute("currentShop");
           if(objShop == null){
               resultMap.put("direct",true);
               resultMap.put("url","/MockShopSystemManager/shop/getShopList");
           }else{
               Shop currentShop = (Shop) objShop;
               resultMap.put("direct",false);
               resultMap.put("shopId",currentShop.getShopId());
           }
        }else {
            Shop currentShop = new Shop();
            currentShop.setShopId(shopId);
            resultMap.put("direct",false);
            resultMap.put("shopId",currentShop.getShopId());
            httpServletRequest.getSession().setAttribute("currentShop",currentShop);
        }
        return  resultMap;
    }

    @GetMapping(value = "/getShopList")
    @ResponseBody
    public HashMap<String,Object> getShopList(HttpServletRequest httpServletRequest) {
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            PersonInfo personInfo = new PersonInfo();
            personInfo.setUserId(1l);
            httpServletRequest.setAttribute("user",personInfo);
            httpServletRequest.getSession().getAttribute("user");

            Shop shopCondition = new Shop();
            shopCondition.setOwner(personInfo);
            ShopResponseExcuttion shopResponseExcuttion = shopService.getShopList(shopCondition,1,20);
            if(shopResponseExcuttion.getState() ==  ShopStateEnum.SUCCESS.getState()){
                resultMap.put("status",200);
                resultMap.put("success",true);
                resultMap.put("shopList",shopResponseExcuttion.getShopList());
            }else {
                resultMap.put("status",1003);
                resultMap.put("success",false);
                resultMap.put("message","查询失败");
            }
        }catch (Exception e){
            resultMap.put("status",1003);
            resultMap.put("success",false);
            resultMap.put("message","查询异常："+e.getMessage());
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
                outputStream.write(butter,0,readByte);
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
