package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.service.Color;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 14:51:58
 */
public class Black implements Color {

    @Override
    public void fill() {
        System.out.println("黑色");
    }
}
