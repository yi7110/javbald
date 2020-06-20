package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:41:09
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "vegburger";
    }

    @Override
    public int price() {
        return 12;
    }
}
