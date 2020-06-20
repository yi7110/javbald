package com.company.fatorydemo;

/**
 * com.company.fatoryDemo
 *
 * @author Liuzf
 * @date 2020-06-16 10:08:49
 */
public class ShapeFactory {

    private static final String  RECTANGLE = "RECTANGLE";
    private static final String  SQUARE = "SQUARE";
    private static final String  CIRCLE = "CIRCLE";

    /**
     *
     * @param shapetype
     * @return
     */
    public Shape getShape(String shapetype){
        if(shapetype == null){
            return null;
        }
        if(shapetype.equals(RECTANGLE)){
            return new Rectangle();
        }if(shapetype.equals(SQUARE)){
            return new Square();
        }if(shapetype.equals(CIRCLE)){
            return new Circle();
        }
        return null;
    }


}
