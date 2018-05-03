package com.yek.annotationConfig;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-03.
 */
@Service
public class FunctionService {
    public void sayHello(String string){
        System.out.println("Hello " + string);
    }
}
