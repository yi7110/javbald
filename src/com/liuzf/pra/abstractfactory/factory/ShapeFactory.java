package com.liuzf.pra.abstractfactory.factory;

import com.liuzf.pra.abstractfactory.*;
import com.liuzf.pra.abstractfactory.service.Color;
import com.liuzf.pra.abstractfactory.service.Shape;

/**
 * com.liuzf.pra.abstractfactory.factory
 *
 * @author Liuzf
 * @date 2020-06-19 14:58:18
 */
public class ShapeFactory extends AbstracFactory {
    @Override
    public Color getColor(String colorType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null || "".equals(shapeType)){
            return null;
        }
        if(shapeType.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        if(shapeType.equalsIgnoreCase("square")){
            return new Square();
        }
        if(shapeType.equalsIgnoreCase("circle")){
            return new Circle();
        }
        return null;
    }
}
