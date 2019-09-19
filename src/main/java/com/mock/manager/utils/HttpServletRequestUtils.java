package com.mock.manager.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 类功能描述：</br>
 *
 * @author yuer
 * @version 1.0 </p>
 * 修改时间：2019-09-17 10:12 </br>
 * 修改备注：</br>
 */
public class HttpServletRequestUtils {

    public static int getInt(HttpServletRequest httpServletRequest,String key){
        int resultInt = -1;
        try {
            resultInt = Integer.decode(httpServletRequest.getParameter(key)) ;
        }catch (Exception e){
            System.out.print(e.getSuppressed());
        }
        return  resultInt;
    }

    public static long getLong(HttpServletRequest httpServletRequest,String key){
        long resultlong = -1l;
        try {
            resultlong = Long.parseLong(httpServletRequest.getParameter(key)) ;
        }catch (Exception e){
            System.out.print(e.getSuppressed());
        }
        return  resultlong;
    }
    public static String getString(HttpServletRequest httpServletRequest,String key){
        String result = "";
        try {
            result = httpServletRequest.getParameter(key) ;
        }catch (Exception e){
            System.out.print(e.getSuppressed());
        }
        return  result;
    }
}
