package com.yek.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by yek on 2018-05-20.
 */
public class DomeEvent extends ApplicationEvent {
    private String msg;
    public DomeEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
