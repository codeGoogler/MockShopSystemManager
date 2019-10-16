package com.mock.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类功能描述：</br>
 * 前端访问的界面
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
@Controller
@RequestMapping(value = "/shopadmin")
public class ShopAdminController {

    @RequestMapping(value = "/regisitShop",method =  RequestMethod.GET)
    public String getShopAdd(){
        return "shop/ShopAdd";
    }

    @RequestMapping(value = "/shoplist",method =  RequestMethod.GET)
    public String shoplist(){
        return "shop/shoplist";
    }
}
