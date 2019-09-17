package com.mock.manager;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类功能描述：</br>
 *
 * @author yuyahao
 * @version 1.0 </p> 修改时间：11/9/2019</br> 修改备注：</br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnit，Spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",})
public class BaseTest {
   public Logger logger = LoggerFactory.getLogger(BaseTest.class);
}
