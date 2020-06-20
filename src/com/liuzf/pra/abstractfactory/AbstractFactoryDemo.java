package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.factory.AbstracFactory;
import com.liuzf.pra.abstractfactory.service.Color;
import com.liuzf.pra.abstractfactory.service.Shape;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 15:23:34
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstracFactory abstracFactory = FactoryProducer.getFactory("color");
        Color red = abstracFactory.getColor("red");
        red.fill();
        AbstracFactory abstracFactory1 = FactoryProducer.getFactory("shape");
        Shape circle = abstracFactory1.getShape("circle");
        circle.draw();
    }
}
