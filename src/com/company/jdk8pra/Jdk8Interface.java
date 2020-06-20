package com.company.jdk8pra;

/**
 * com.company.jdk8pra
 *
 * @author Liuzf
 * @date 2020-06-18 23:20:14
 */
@FunctionalInterface
public interface Jdk8Interface {

    /**
     * jdk8新特性，接口里面可以有静态方法和默认方法
     */
    static void method1(){
        System.out.println("静态方法1");
    }
    default void method2(){
        System.out.println("默认方法1");
    }

    /**
     *函数式接口，有且仅有一个抽象方法的接口
     */
    void method3();
}



