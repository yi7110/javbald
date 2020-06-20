package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.service.Color;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 14:51:15
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("红色");
    }
}
