# bookstore java code

#1.外部配置-命令行参数配置

Spring Boot是基于jar包运行的，打成jar包的程序可以直接通过下面命令运行：

可以以下命令修改tomcat端口号：
java -jar xx.jar --server.port=9090 

可以看出，命令行中连续的两个减号--就是对application.properties`中的属性值进行赋值的标识。

所以java -jar xx.jar --server.port=9090等价于在application.properties中添加属性server.port=9090。

如果你怕命令行有风险，可以使用SpringApplication.setAddCommandLineProperties(false)禁用它。

#2. 集成shiro
> 参考： https://www.cnblogs.com/hlhdidi/p/6376457.html
        http://blog.csdn.net/u013615903/article/details/78781166
        http://blog.csdn.net/liuchuanhong1/article/details/76179601
###2.1 搭建
####2.1.1 添加shiro依赖
```
 <dependency>
     <groupId>org.apache.shiro</groupId>
     <artifactId>shiro-spring</artifactId>
     <version>1.4.0</version>
 </dependency>
```
####2.1.2 添加JPA和MYSQL驱动
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <!--<scope>runtime</scope>-->
</dependency>
```
####2.1.3 application.properties配置
#####2.1.3.1 datasource配置
```
spring.datasource.url = jdbc:mysql://localhost:3306/test  
spring.datasource.username = root  
spring.datasource.password = root  
spring.datasource.driverClassName = com.mysql.jdbc.Driver  
spring.datasource.max-active=20  
spring.datasource.max-idle=8  
spring.datasource.min-idle=8  
spring.datasource.initial-size=10  
```
#####2.1.3.2 Java Persistence Api  配置
```
# Specify the DBMS  
spring.jpa.database = MYSQL  
# Show or not log for each sql query  
spring.jpa.show-sql = true  
# Hibernate ddl auto (create, create-drop, update)  
spring.jpa.hibernate.ddl-auto = update  
# Naming strategy  
#[org.hibernate.cfg.ImprovedNamingStrategy | org.hibernate.cfg.DefaultNamingStrategy]  
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.DefaultNamingStrategy  
# stripped before adding them to the entity manager)  
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect  
```
####2.1.4 新建实体类
>根据Shiro的设计思路，用户与角色之前的关系为多对多，角色与权限之间的关系也是多对多。在数据库中需要因此建立5张表，分别是用户表（存储用户名，密码，盐等）、角色表（角色名称，相关描述等）、权限表（权限名称，相关描述等）、用户-角色对应中间表（以用户ID和角色ID作为联合主键）、角色-权限对应中间表（以角色ID和权限ID作为联合主键）。总之结论就是，Shiro需要根据用户名和密码首先判断登录的用户是否合法，然后再对合法用户授权。而这个过程就是Realm的实现过程。
