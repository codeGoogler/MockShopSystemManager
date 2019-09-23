package com.mock.manager.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：23/9/2019</br> 修改备注：</br>
 */
public class VertifyCodeUtils {
    /**
     * 判断传入的验证码是否相等
     * @return
     */
    public static  boolean checkVertifyCode(HttpServletRequest httpServletRequest){
        String vertifyExcept = (String) httpServletRequest.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String vertityodeActual = HttpServletRequestUtils.getString(httpServletRequest,"vetifyCode");
        System.out.println(vertifyExcept+"    " +vertityodeActual);
        if(vertifyExcept == null || !vertityodeActual.equals(vertifyExcept)){
            return false;
        }
        return true;
    }
}
