package com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl;

import com.yek.designPattern.common.Color;
import com.yek.designPattern.common.MyColorEnum;
import com.yek.designPattern.common.MyShapeEnum;
import com.yek.designPattern.common.Shape;

/**
 * Created by Administrator on 2018-03-25.
 */
public abstract class AbstractFactory {
    public abstract Color getColor(MyColorEnum color);
    public abstract Shape getShape(MyShapeEnum shape);
}
