package com.mock.manager.utils;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：9/10/2019</br> 修改备注：</br>
 */
public class PageCalculator {

    /**
     * 从第pageNo行开始，搜索pageSize条数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static int calculRowIndex(int pageNo , int pageSize){
        return  pageNo > 0 ? (pageNo-1) * pageSize:0;
    }

}
