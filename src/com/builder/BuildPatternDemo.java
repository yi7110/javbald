package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 17:11:09
 */
public class BuildPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        /**
         * 套餐vegmeal
         */
        Meal vegMeal = mealBuilder.prepareVegBurger(2);
        System.out.println("vegMeal:");
        vegMeal.showMeal();
        System.out.println("Total Cost:"+vegMeal.getCost());

        /**
         * 套餐chickenMeal
         */
        Meal chickenBurger = mealBuilder.prepareChickenBurger(2);
        System.out.println("chickenMeal:");
        chickenBurger.showMeal();
        System.out.println("Total Cost:"+chickenBurger.getCost());

    }
}
