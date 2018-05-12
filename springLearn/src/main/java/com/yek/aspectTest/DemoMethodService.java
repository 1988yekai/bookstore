package com.yek.aspectTest;

import org.springframework.stereotype.Service;

/**
 * Created by yek on 2018-05-12.
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println(this.getClass().getName()+ ": add();");
    }
}
