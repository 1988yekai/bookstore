package com.yek.annotationConfig2;

/**
 * Created by Administrator on 2018-05-05.
 */
public class UseFunctionService {
    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public void sayHello(String string){
        functionService.sayHello(string);
    }
}
