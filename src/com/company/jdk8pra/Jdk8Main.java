package com.company.jdk8pra;

import javax.swing.plaf.TableHeaderUI;

/**
 * com.company.jdk8pra
 *
 * @author Liuzf
 * @date 2020-06-18 23:21:52
 */
public class Jdk8Main {

    public static void main(String[] args) {
        /**
         * 静态方法只能用接口名调用

        *Jdk8Interface.method1();
         * 默认方法只能用实现类对象调用

        new Jdk8InterfaceImpl().method2();

        show(()-> System.out.println("lamdba表达式执行了。。。。。。"));
        sum(2,3,(c,d)->c*d);*/

        printStr(System.out::println);
        printStr(str -> System.out.println(str));
    }

    public static void show(Jdk8Interface j1){
        j1.method3();
    }

    public static void sum(int a,int b,Jdk8MyInterface jdk8MyInterface){
        System.out.println(jdk8MyInterface.sum(a,b));
    }

    public static void printStr(Printable pt){
        pt.printStr("Hello World");
    }
}
