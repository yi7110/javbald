package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:43:02
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke";
    }


    @Override
    public int price() {
        return 10;
    }
}
