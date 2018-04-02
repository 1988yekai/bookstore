#springboot 学习项目


####关于一对多报错问题
报错原因是：在双向一对多的时候，在序列化和反序列化A是，需要把B里的内容取出，而且A里面又有B的集合，如此反复，便会出现死循环。
解决方案：
- 第一种：
一对多的一方的集合Get方法上使用注解@JsonIgnore
- 第二种：
在一方的类上使用注解@JsonIgnoreProperties(value={"listPerson","listProducts"})
value:是集合的属性名。（自己定义的属性名）
- 第三种（推荐）：在get方法上加 @JsonBackReference(value="user-movement")//阻止2次以上的循环调用 
>    @JsonBackReference(value="user-movement")

>    public Set<Student> getStudents() {
          return students;
      }
####参考网站
- springboot介绍 https://blog.csdn.net/isea533/article/details/50412212
- 实体主键生成策略 http://www.javacui.com/opensource/362.html
- jpa关系注解（1对1，多对多，1对多） https://www.cnblogs.com/nelson-hu/p/7289289.html
- mappedBy注解 https://www.cnblogs.com/ShawnYuki/p/6363547.html
- webjar查询网站 http://www.webjars.org/
- thymeleaf模板 https://blog.csdn.net/u012706811/article/details/52185345
https://www.cnblogs.com/zhufu9426/p/7873153.html
- bootstrap-table示例 https://blog.csdn.net/hanxue_tyc/article/details/54917227
