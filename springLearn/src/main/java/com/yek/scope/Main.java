package com.yek.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018-05-08.
 */

@Configuration
@ComponentScan("com.yek.scope")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        SingletonService singletonService = (SingletonService) context.getBean("singletonService");
        SingletonService singletonService1 = context.getBean(SingletonService.class);
        PrototypeService prototypeService = context.getBean(PrototypeService.class);
        PrototypeService prototypeService1 = context.getBean(PrototypeService.class);

        System.out.println(singletonService == singletonService1);
        System.out.println(prototypeService == prototypeService1);
        context.close();
    }
}
