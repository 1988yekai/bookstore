package com.yek.designPattern.abstractFactoryPattern;

import com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl.AbstractFactory;
import com.yek.designPattern.common.Color;
import com.yek.designPattern.common.MyColorEnum;
import com.yek.designPattern.common.MyShapeEnum;
import com.yek.designPattern.common.Shape;

/**
 * Created by Administrator on 2018-03-25.
 */
public class Main {
    public static void main(String[] args) {
        //1.获取形状工厂
        AbstractFactory shape = FactoryProducer.getFactory("shape");
        Shape circle = shape.getShape(MyShapeEnum.CIRCLE);
        circle.draw();
        //2.获取颜色工厂
        AbstractFactory color = FactoryProducer.getFactory("color");
        Color red = color.getColor(MyColorEnum.RED);
        red.fill();
    }
}
