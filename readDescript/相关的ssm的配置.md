### 前言

最近在练习Spring项目配置，参考项目：
>  https://github.com/yuerLoveCoding/MockShopSystemManager


### 理解Spring?

**具体来说Spring是一个轻量级的容器，用于管理业务相关对象的。核心功能主要为：**

* IOC
* AOP
* MVC


**IOC：**控制反转，将对象的创建过程交给容器，让容器管理对象的生命周期如创建，初始化，销毁等。

**AOP：**面向切面编程，对关注点进行模块化，通过对某一功能点进行编程，比如记录日志，有很多个类都需要记录日志的方法，则创建记录日志的代理方法，需要调用该功能是只需要调用代理方法，这就是AOP。

**MVC:**SpringMvc,Spring提供的基于MVC模式设计的Web框架，如今比较流行的框架之一。
 

###  **Mybaties之mybaties-config.xml配置文件:**

```
<?xml version="1.0" encoding="UTF-8"?>    
<!DOCTYPE configuration 
PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!-- 配置全局属性 -->
    <settings>
        <!--  使用jdbc的getGeneratedKeys获取数据库自增主键值 -->
        <setting name="useGeneratedKeys" value="true"/>
        <!-- 使用列别名代替列名 -->
        <setting name="useColumnLabel" value="true"/>
        <!-- 开启自动驼峰命名规则 -->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    
</configuration>
```


###  **分布式项目开发-spring-dao.xml基础配置:**

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

    <!-- 数据源 -->
    <bean id="dataSource"
        class="com.alibaba.druid.pool.DruidDataSource">
        <property name="username" value="${db.username}" />
        <property name="password" value="${db.password}" />
        <property name="url" value="${db.url}" />
        <property name="driverClassName"
            value="${db.driverClassName}" />
    </bean>

    <!-- sqlSessionFactory -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!-- is org.apache.ibatis.builder.BuilderException 缺少约束头导致 -->
        <property name="configLocation" value="classpath:mybatis.cfg.xml"/>
    </bean>

    <!-- mapperScan -->
    <bean id="mapperScan" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
      <property name="basePackage" value="com.sxt.mapper"/>
      <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>
</beans>
```

###  **Spring之Service层配置文件**

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">
<!-- 扫描service包下使用了service注解的类 -->
<context:component-scan base-package="com.imooc.o2o.service" />

<!-- 配置transactionManager对象 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!-- 注入数据库连接池 -->
    <property name="dataSource" ref="dataSource" />
</bean>

<!-- 配置基于注解的声明式事务管理 -->
<tx:annotation-driven transaction-manager="transactionManager" />  

</beans>
```
**项目地址：**

>  https://github.com/yuerLoveCoding/MockShopSystemManager