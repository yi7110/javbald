package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:10:24
 */
public abstract class Burger implements Item{

    @Override
    public Packing pack(){
        return new Wrapper();
    }

    @Override
    public abstract int price();
}
