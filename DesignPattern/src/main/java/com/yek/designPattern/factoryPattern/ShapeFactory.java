package com.yek.designPattern.factoryPattern;

import com.yek.designPattern.factoryPattern.interfaceAndImpl.*;

/**
 * Created by Administrator on 2018-3-16.
 */
public class ShapeFactory {
    public Shape getShape(MyShape shapeType){
        if (null == shapeType)
            return null;
        if (shapeType == MyShape.CIRCLE)
            return new Circle();
        else if (shapeType == MyShape.SQUARE)
            return new Square();
        else if (shapeType == MyShape.RECTANGLE)
            return new Rectangle();
        return null;
    }
}
