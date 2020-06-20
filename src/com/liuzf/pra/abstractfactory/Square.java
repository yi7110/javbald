package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.service.Shape;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 14:50:04
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("正方形");
    }
}
