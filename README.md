#### springboot-demo 创建时间： 2018-11-20
springboot 学习实践 demo
 
---- 

##### 效果展示 springboot + mybatis RESTful CRUD 2018-11-21

![效果展示](http://zyrs-xyz.oss-cn-beijing.aliyuncs.com/upload-picture/861136242/1542950683262_Image.png?x-oss-process=style/zyrs-picture-style)

##### springboot  事务操作  2018-11-25

##### springboot + redis 非注解与注解式  2018-11-27

##### springboot +logback 日志系统使用  2018-11-28

##### springboot +shiro 权限管理 角色 MDS多次加密  记住我  2018-11-29


![效果展示](http://zyrs-xyz.oss-cn-beijing.aliyuncs.com/upload-picture/861136242/1543472694030_447_0.jpg?x-oss-process=style/zyrs-picture-style)


##### springboot  404页面 热部署
  
   在templates/error 下面  加入error.html(404,403,500) 文件即可

   导入依赖

        <!-- 热部署模块 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional> <!-- 这个需要为 true 热部署才有效 -->
        </dependency>  

   设置 spring.thymeleaf.cache=false  开发环境禁用缓存