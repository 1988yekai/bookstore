package com.yek.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-03.
 */
@Service
public class UseFunctionService {
    @Autowired
    private FunctionService service;
    public void sayHello(String string){
        service.sayHello(string);
    }
}
