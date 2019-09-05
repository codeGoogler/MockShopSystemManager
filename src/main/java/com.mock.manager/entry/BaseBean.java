package com.mock.manager.entry;

import java.io.Serializable;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2019/9/5</br> 修改备注：</br>
 */
public abstract  class BaseBean<T>  implements Serializable {

    public abstract T parseModel(String obj);

}
