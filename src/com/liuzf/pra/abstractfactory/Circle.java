package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.service.Shape;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 14:49:14
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}
