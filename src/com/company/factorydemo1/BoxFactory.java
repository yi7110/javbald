package com.company.factorydemo1;

/**
 * com.company.factorydemo1
 *
 * @author Liuzf
 * @date 2020-06-20 12:53:10
 */
public class BoxFactory {

    private final static String RED = "red";
    private final static String black = "black";
    public void getBox(String type){
        if(null == type){
            System.out.println("请确认盒子类型，黑盒子和红盒子两种。");
        }
        if(RED.equalsIgnoreCase(type)){
            Box b = new RedBox();
            System.out.println(b.draw()+" "+b.fill());
        }
        if(black.equalsIgnoreCase(type)){
            Box b = new BlackBox();
            System.out.println(b.draw()+" "+b.fill());
        }
    }
}
