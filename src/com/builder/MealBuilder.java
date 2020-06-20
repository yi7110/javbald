package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:59:20
 */
public class MealBuilder {

    public Meal prepareVegBurger(int num){
        Meal meal = new Meal(num);
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenBurger(int num){
        Meal meal = new Meal(num);
        meal.addItem(new ChickenBurger());
        meal.addItem(new pepsi());
        return meal;
    }
}
