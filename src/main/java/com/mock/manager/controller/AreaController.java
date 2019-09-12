package com.mock.manager.controller;

import com.mock.manager.entry.Areas;
import com.mock.manager.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：11/9/2019</br> 修改备注：</br>
 */
@Controller
@RequestMapping("/area")
public class AreaController {
    @Autowired
    AreaService areaService;


    @RequestMapping(value = "/searchAll",method = RequestMethod.GET)
    @ResponseBody
    public String searchAll(){
      /*  List<Areas> list=  areaService.queryAllArea();
        for (int i = 0; i <list.size() ; i++) {
            Areas area = list.get(i);
            System.out.println(area);
        }*/
        return "index";
    }
}
