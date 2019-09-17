package com.mock.manager.service.impl;

import com.mock.manager.dao.AreaDao;
import com.mock.manager.entry.Area;
import com.mock.manager.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：11/9/2019</br> 修改备注：</br>
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryAllArea() {
        return  areaDao.queryAllArea();
    }
}
