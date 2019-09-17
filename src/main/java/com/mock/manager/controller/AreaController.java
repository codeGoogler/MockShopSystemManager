package com.mock.manager.controller;


import com.mock.manager.entry.Area;
import com.mock.manager.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    AreaService areaService;


    @RequestMapping(value = "/searchAll",method = RequestMethod.GET)
    @ResponseBody
    public String searchAll(){
        logger.info("========start===============");
        long startTime = System.currentTimeMillis();
      List<Area> list=  areaService.queryAllArea();
        for (int i = 0; i <list.size() ; i++) {
            Area area = list.get(i);
            System.out.println(area);
        }
        long endTime = System.currentTimeMillis();
        logger.debug("所用的时间[{}ms]",endTime-startTime);
        logger.info("============end==============");
        return "index";
    }
}
