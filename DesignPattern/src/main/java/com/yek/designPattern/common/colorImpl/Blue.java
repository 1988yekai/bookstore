package com.yek.designPattern.common.colorImpl;

import com.yek.designPattern.common.Color;

/**
 * Created by Administrator on 2018-03-25.
 */
public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("Blue::fill() method.");
    }
}
