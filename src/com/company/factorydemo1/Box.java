package com.company.factorydemo1;

/**
 * com.company.factorydemo1
 *
 * @author Liuzf
 * @date 2020-06-20 12:42:42
 */
public abstract class Box implements Circle,Shape {
    @Override
    public abstract String fill();

    @Override
    public String draw() {
        return "正方形";
    }

    public static String log1(){
        return "日志1";
    }

}
