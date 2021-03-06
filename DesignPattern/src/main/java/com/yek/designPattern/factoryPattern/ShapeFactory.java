package com.yek.designPattern.factoryPattern;

import com.yek.designPattern.common.*;
import com.yek.designPattern.common.shapeImpl.Circle;
import com.yek.designPattern.common.shapeImpl.Rectangle;
import com.yek.designPattern.common.shapeImpl.Square;

/**
 * Created by Administrator on 2018-3-16.
 */
public class ShapeFactory {
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
