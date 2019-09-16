
#### 解决：Spring-MVC jsp中文 乱码问题

**1、首先检查web.xml文件，是否增加编码过滤器，且forceEncoding为true**

```
<filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

**2、其次检查JSP文件，head头部是否添加编码文件**


```
<html>
<head>
    <meta charset=“UTF-8”>
    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <title>欢迎页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
</head>
<body>
<h2>Hello World!你好啊 的 奋斗是地方是v</h2>
${user1}
</body>
</html>
```

**3、必须通过表单（post、get)方法进行，否则编码过滤器不起效果**

```

<body>
       <form action="/hello/login1"  method="post">
	用户名：<input type="text" name="userName">
	密码：<input type="password" name="password">
	<button type="submit">提交</button>
    	</form>
</body>

```
####  idea启动tomcat访问页面中文乱码

最近IDE从eclipse改成IntelliJ IDEA 了，原因是公司大部分人都在用这个IDE，而且一直推荐用，所以尝尝鲜。换的第一天，就遇到了哪个IDE都会遇到的乱码问题，耗费了好多时间最终解决了，因此在这边记录一下解决方案，以供后面参考。

总共有下面几种乱码的解决方案：

1.  工程乱码
2.  执行main函数时，控制台乱码
3.  运行tomcat时，控制台乱码

**PS: 如果下面方案不生效时**，打开IDEA安装目录找到** idea.exe.vmoptions**（64位为**idea64.exe.vmoptions**）文件， 在文件末尾加上 **-Dfile.encoding=UTF-8**

**可以先做这一步，加上这个基本上很多都不会乱码了**

## 1.工程乱码

打开File-Setting, 找到File Encodings这个选项，把encoding设置成你工程的编码即可，一般是UTF-8，如下图（红框的地方），然后重新rebuild一下，基本就行了

![image.png](https://upload-images.jianshu.io/upload_images/14371339-9c934ed4e9f909e6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 2.执行main函数时，控制台乱码

同样是打开setting，找到 Build,Execution,Deployment > Compiler > Java Compiler， 设置 Additional command line parameters选项为 -encoding utf-8，然后rebuild下，重新运行

![image.png](https://upload-images.jianshu.io/upload_images/14371339-2db8c153401c5963.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 3.运行tomcat时，控制台乱码

1） 打开Run/Debug Configuration,选择你的tomcat

![image.png](https://upload-images.jianshu.io/upload_images/14371339-5e332560da5c808d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2) 然后在  Server > VM options 设置为 -Dfile.encoding=UTF-8 ，重启tomcat

![image.png](https://upload-images.jianshu.io/upload_images/14371339-b55c3b37bb71f1ec.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

####  第一种编码的修改：File-->Settings-->Editor-->File Encodings
 
 将这三个地方都设置成UTF-8，使文件的编码格式都是UTF-8（不过这个貌似跟Tomcat乱码没多大关系）
 
 ![ ](https://upload-images.jianshu.io/upload_images/14371339-4599547bbab8e594?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
 
 第三种：在...\JetBrains\IntelliJ IDEA 2018.1.5\bin   目录下找到idea.exe.vmoptions（64位idea64.exe.vmoptions）
 
 增加一条  -Dfile.encoding=UTF-8
 
 
 
 ![ ](https://upload-images.jianshu.io/upload_images/14371339-c71e17c222d03068?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
 
 
 目前我认为是这三种方式一起用然后我的问题就解决了...
  

 