package com.yek.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by yek on 2018-05-20.
 */
@Component
public class DemoListener implements ApplicationListener<DomeEvent> {
    @Override
    public void onApplicationEvent(DomeEvent domeEvent) {
        String msg = domeEvent.getMsg();
        System.out.println("listener get message: " + msg);
    }
}
