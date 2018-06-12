package com.yek.taskScheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by yek on 2018-06-12.
 */
@EnableScheduling
@Configuration
@ComponentScan("com.yek.taskScheduler")
public class Entry {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Entry.class);

    }
}
