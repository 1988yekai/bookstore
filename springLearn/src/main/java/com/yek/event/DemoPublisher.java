package com.yek.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by yek on 2018-05-20.
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext context;
    public void publish(String msg){
        context.publishEvent(new DomeEvent(this,msg));
    }
}
