package com.yek.annotationConfig2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018-05-05.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        useFunctionService.sayHello("useFunctionService!");
        System.out.println("=========================================");
        FunctionService functionService = context.getBean(FunctionService.class);
        functionService.sayHello("functionService!");

        context.close();
    }
}
