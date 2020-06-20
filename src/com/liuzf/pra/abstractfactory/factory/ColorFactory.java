package com.liuzf.pra.abstractfactory.factory;

import com.liuzf.pra.abstractfactory.Black;
import com.liuzf.pra.abstractfactory.Red;
import com.liuzf.pra.abstractfactory.Yellow;
import com.liuzf.pra.abstractfactory.service.Color;
import com.liuzf.pra.abstractfactory.service.Shape;

/**
 * com.liuzf.pra.abstractfactory.factory
 *
 * @author Liuzf
 * @date 2020-06-19 15:13:42
 */
public class ColorFactory extends AbstracFactory {
    @Override
    public Color getColor(String colorType) {
        if(colorType == null || "".equals(colorType)){
            return null;
        }
        if(colorType.equalsIgnoreCase("red")){
            return new Red();
        }
        if(colorType.equalsIgnoreCase("black")){
            return new Black();
        }
        if(colorType.equalsIgnoreCase("yellow")){
            return new Yellow();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
