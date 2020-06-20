package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:25:24
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chicken burger";
    }

    @Override
    public int price() {
        return 15;
    }
}
