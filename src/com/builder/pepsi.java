package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:44:36
 */
public class pepsi extends ColdDrink {
    @Override
    public String name() {
        return "pepsi";
    }

    @Override
    public int price() {
        return 9;
    }
}
