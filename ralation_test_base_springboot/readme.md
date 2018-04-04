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
- Spring data JPA示例 https://blog.csdn.net/liuchuanhong1/article/details/52042477
- mappedBy注解 https://www.cnblogs.com/ShawnYuki/p/6363547.html
- webjar查询网站 http://www.webjars.org/
- thymeleaf模板 https://blog.csdn.net/u012706811/article/details/52185345
https://www.cnblogs.com/zhufu9426/p/7873153.html
- bootstrap-table示例 https://blog.csdn.net/hanxue_tyc/article/details/54917227
http://www.jb51.net/article/93248.htm
- QueryDSL的DEMO示例 https://blog.csdn.net/zhang89xiao/article/details/78240318

####QueryDSL
参考网址 https://blog.csdn.net/liuchuanhong1/article/details/70244261?utm_source=gold_browser_extension
> 注意：springboot 版本 1.5.8.RELEASE 和 2.0.0.RELEASE 类名有区别

1、 pom依赖

        <!--query dsl -->  
        <dependency>  
            <groupId>com.querydsl</groupId>  
            <artifactId>querydsl-jpa</artifactId>  
        </dependency>  
        <dependency>  
            <groupId>com.querydsl</groupId>  
            <artifactId>querydsl-apt</artifactId>  
            <scope>provided</scope>  
        </dependency>  

2、pom文件中，加入编译插件

            <plugin>  
                <groupId>com.mysema.maven</groupId>  
                <artifactId>apt-maven-plugin</artifactId>  
                <version>1.1.3</version>  
                <executions>  
                    <execution>  
                        <goals>  
                            <goal>process</goal>  
                        </goals>  
                        <configuration>  
                            <outputDirectory>target/generated-sources/java</outputDirectory>  
                            <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>  
                        </configuration>  
                    </execution>  
                </executions>  
            </plugin>  
3、 编写实体类，mvn compile, 生成对应 QXX.class 查询类型，剪切到实体类同包下。
4、 使用示例：

    import org.springframework.data.jpa.repository.JpaRepository;  
    import org.springframework.data.querydsl.QueryDslPredicateExecutor;  
    import com.xxx.xxx.entity.User;  
    public interface UserRepositoryDls extends JpaRepository<User, Integer>, QueryDslPredicateExecutor<User>{// 继承QueryDslPredicateExecutor接口  
    } 
QueryDslPredicateExecutor接口提供了如下方法：
> *注意 2.0.0版本更新为 QuerydslPredicateExecutor

    public interface QueryDslPredicateExecutor<T> {  
        T findOne(Predicate predicate);  
        Iterable<T> findAll(Predicate predicate);  
        Iterable<T> findAll(Predicate predicate, Sort sort);  
        Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);  
        Iterable<T> findAll(OrderSpecifier<?>... orders);  
        Page<T> findAll(Predicate predicate, Pageable pageable);  
        long count(Predicate predicate);  
        boolean exists(Predicate predicate);  
    } 
测试代码：

    public User findUserByUserName(final String userName){  
    /** 
     * 该例是使用spring data QueryDSL实现 
     */  
        QUser quser = QUser.user;  
        Predicate predicate = quser.name.eq(userName);// 根据用户名，查询user表  
        //predicate = ExpressionUtils.or(predicate, QStudent.student.age.lt(12));//多条件查询 添加or条件
        return repository.findOne(predicate);  
    }  

5、 QSort 的使用：

    QSort sort = new QSort(QStudent.student.name.asc());
    sort.and(QStudent.student.sid.desc());//添加下一个排序条件
    QPageRequest page = new QPageRequest(pageNumber - 1, pageSize, sort);

