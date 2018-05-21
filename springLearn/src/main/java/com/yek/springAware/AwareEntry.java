package com.yek.springAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yek on 2018-05-21.
 */
@Configuration
@ComponentScan("com.yek.springAware")
public class AwareEntry {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareEntry.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResoult();

        context.close();
    }
}
