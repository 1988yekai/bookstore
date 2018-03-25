package com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl;

import com.yek.designPattern.common.Color;
import com.yek.designPattern.common.MyColorEnum;
import com.yek.designPattern.common.MyShapeEnum;
import com.yek.designPattern.common.Shape;
import com.yek.designPattern.common.colorImpl.Black;
import com.yek.designPattern.common.colorImpl.Blue;
import com.yek.designPattern.common.colorImpl.Red;
import com.yek.designPattern.common.shapeImpl.Circle;
import com.yek.designPattern.common.shapeImpl.Rectangle;
import com.yek.designPattern.common.shapeImpl.Square;

import static java.awt.Color.black;

/**
 * Created by Administrator on 2018-03-25.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(MyColorEnum color) {
        if (null == color)
            return null;
        if (color == MyColorEnum.BLACK)
            return new Black();
        else if (color == MyColorEnum.BLUE)
            return new Blue();
        else if (color == MyColorEnum.RED)
            return new Red();
        return null;
    }

    @Override
    public Shape getShape(MyShapeEnum shapeType){
        return null;
    }
}
