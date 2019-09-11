package com.mock.manager.controller;

import com.mock.manager.entry.Areas;
import com.mock.manager.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：11/9/2019</br> 修改备注：</br>
 */
@Controller
@RestController("/area")
public class AreaController {
    @Autowired
    AreaService areaService;


    @PutMapping("/searchAll")
    public String searchAll(){
        List<Areas> list=  areaService.queryAllArea();
        for (int i = 0; i <list.size() ; i++) {
            Areas area = list.get(i);
            System.out.println(area);
        }
        return "index";
    }
}
