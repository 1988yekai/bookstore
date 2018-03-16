package com.yek.designPattern.factoryPattern;

import com.yek.designPattern.factoryPattern.interfaceAndImpl.MyShape;
import com.yek.designPattern.factoryPattern.interfaceAndImpl.Shape;

/**
 * Created by Administrator on 2018-3-16.
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactory shape = new ShapeFactory();
        Shape circle = shape.getShape(MyShape.CIRCLE);
        Shape square = shape.getShape(MyShape.SQUARE);
        Shape rectangle = shape.getShape(MyShape.RECTANGLE);

        circle.draw();
        square.draw();
        rectangle.draw();
    }
}
