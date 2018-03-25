package com.yek.designPattern.abstractFactoryPattern;

import com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl.AbstractFactory;
import com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl.ColorFactory;
import com.yek.designPattern.abstractFactoryPattern.interfaceAndImpl.ShapeFactory;

/**
 * Created by Administrator on 2018-03-25.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryType){
        if ("SHAPE".equalsIgnoreCase(factoryType)){
            return new ShapeFactory();
        } else if ("COLOR".equalsIgnoreCase(factoryType)){
            return new ColorFactory();
        }
        return null;
    }
}
