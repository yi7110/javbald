package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:13:31
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing pack(){
        return new Bottle();
    }
    @Override
    public abstract int price();
}
