package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.factory.AbstracFactory;
import com.liuzf.pra.abstractfactory.factory.ColorFactory;
import com.liuzf.pra.abstractfactory.factory.ShapeFactory;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 15:18:33
 */
public class FactoryProducer {
    public static AbstracFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }
        if(choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }
}
