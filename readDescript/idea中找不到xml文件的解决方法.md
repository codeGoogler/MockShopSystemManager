参考链接：https://blog.csdn.net/qq_41706670/article/details/84842550

#### 前言

```
Caused by: java.io.FileNotFoundException: class path resource [spring/] cannot be resolved to URL because it does not exist
```

![ ](https://upload-images.jianshu.io/upload_images/14371339-14c6f1c0a3d9ec36.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


问题描述：在使用idea学习spring的ioc时，我想用xxx.xml引入其他的配置文件(spring-dao.xml，spring-service.xml，spring-web.xml)，hello.xml是放在单独的java包中的。文件目录：

![ ](https://upload-images.jianshu.io/upload_images/14371339-ac889112f049e453.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


 

进行单元测试，报错显示该xml未找到。打开项目文件显示：



因此可以看出在运行的时候idea并未将xml编译到target目录下。经过搜索找到了解决方法：在pom.xml中<build></build>内添加一段代码：

    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>*</include>
          <include>*/*</include>
        </includes>
        <filtering>true</filtering>
      </resource>
      <!--xml编译到源码下面 -->
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.xml</include>
        </includes>
      </resource>
    </resources>

代码比较简单易懂，就是将java文件夹下的java文件和xml文件都自动编译到target目录下。

再次编译，结果还是classpath找不到，然后查看编译的class文件和resourcec文件

![ ](https://upload-images.jianshu.io/upload_images/14371339-fb6244674eeadb95.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 解决方式

 把resources变成resources资源目录件xml文件放在resources下即可

![  把resources变成resources资源目录](https://upload-images.jianshu.io/upload_images/14371339-e9a25f87ca24cddf?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### 再次运行，完美

![ ](https://upload-images.jianshu.io/upload_images/14371339-5a403a499cbfcf50.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
