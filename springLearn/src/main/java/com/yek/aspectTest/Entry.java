package com.yek.aspectTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yek on 2018-05-12.
 */
@Configuration
@ComponentScan("com.yek.aspectTest")
@EnableAspectJAutoProxy// open aspect
public class Entry {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Entry.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        demoAnnotationService.add(1,2);
        demoMethodService.add();

        context.close();
    }
}
