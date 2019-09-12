package com.mock.manager.dao;

import com.mock.manager.BaseTest;
import com.mock.manager.entry.Areas;
import com.mock.manager.service.AreaService;
import com.mock.manager.service.impl.AreaServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：11/9/2019</br> 修改备注：</br>
 */
public class AreaServiceTest extends BaseTest {


    @Autowired
    private AreaService areaService;


    @Test
    public void testQueryAreaAll(){
        List<Areas> list =  areaService.queryAllArea();
        for (int i = 0; i <list.size() ; i++) {
            Areas area = list.get(i);
            System.out.println(area);
        }

       /* list.stream().filter(student -> student != null).forEach(student -> {
            if (student.getAreaId() != 0) System.out.println(student.toString());
        });*/

       /* list.stream().filter(area -> area !=null).forEach(area->
                { System.out.println(area)}
                );*/
    }
}
