package com.yek.designPattern.factoryPattern;

import com.yek.designPattern.common.MyShapeEnum;
import com.yek.designPattern.common.Shape;

/**
 * Created by Administrator on 2018-3-16.
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactory shape = new ShapeFactory();
        Shape circle = shape.getShape(MyShapeEnum.CIRCLE);
        Shape square = shape.getShape(MyShapeEnum.SQUARE);
        Shape rectangle = shape.getShape(MyShapeEnum.RECTANGLE);

        circle.draw();
        square.draw();
        rectangle.draw();
    }
}
