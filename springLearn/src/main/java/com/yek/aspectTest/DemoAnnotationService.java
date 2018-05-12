package com.yek.aspectTest;

import org.springframework.stereotype.Service;

/**
 * Created by yek on 2018-05-12.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的add方法")
    public void add(int a, int b){
        System.out.println(this.getClass().getName()+": add();");
        System.out.println("a + b = " + (a + b));
    }
}
