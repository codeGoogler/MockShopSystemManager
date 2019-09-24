package com.mock.manager.controller;

import com.mock.manager.entry.Area;
import com.mock.manager.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：24/9/2019</br> 修改备注：</br>
 */
@Controller
@RequestMapping("/localAuthCOmtroller")
public class localAuthCOmtroller {


        Logger logger = LoggerFactory.getLogger(com.mock.manager.controller.AreaController.class);
        @Autowired
        AreaService areaService;


        @RequestMapping(value = "/searchAll",method = RequestMethod.GET)
        @ResponseBody
        public String searchAll(){
            logger.info("========start======e=========");
            long endTime = System.currentTimeMillis();
            logger.info("============end====w==========");
            return "index";
        }
}