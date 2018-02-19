# bookstore java code

#1.外部配置-命令行参数配置

Spring Boot是基于jar包运行的，打成jar包的程序可以直接通过下面命令运行：

可以以下命令修改tomcat端口号：
java -jar xx.jar --server.port=9090 

可以看出，命令行中连续的两个减号--就是对application.properties`中的属性值进行赋值的标识。

所以java -jar xx.jar --server.port=9090等价于在application.properties中添加属性server.port=9090。

如果你怕命令行有风险，可以使用SpringApplication.setAddCommandLineProperties(false)禁用它。

#2. 集成shiro
参考： https://www.cnblogs.com/hlhdidi/p/6376457.html
        http://blog.csdn.net/u013615903/article/details/78781166