package com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl;

import com.yek.designPattern.common.Color;
import com.yek.designPattern.common.MyColorEnum;
import com.yek.designPattern.common.MyShapeEnum;
import com.yek.designPattern.common.Shape;
import com.yek.designPattern.common.shapeImpl.Circle;
import com.yek.designPattern.common.shapeImpl.Rectangle;
import com.yek.designPattern.common.shapeImpl.Square;

/**
 * Created by Administrator on 2018-03-25.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(MyColorEnum color) {
        return null;
    }

    @Override
    public Shape getShape(MyShapeEnum shapeType){
        if (null == shapeType)
            return null;
        if (shapeType == MyShapeEnum.CIRCLE)
            return new Circle();
        else if (shapeType == MyShapeEnum.SQUARE)
            return new Square();
        else if (shapeType == MyShapeEnum.RECTANGLE)
            return new Rectangle();
        return null;
    }
}
