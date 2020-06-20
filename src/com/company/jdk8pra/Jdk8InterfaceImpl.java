package com.company.jdk8pra;

/**
 * com.company.jdk8pra
 *
 * @author Liuzf
 * @date 2020-06-18 23:23:36
 */
public class Jdk8InterfaceImpl implements Jdk8Interface {

    @Override
    public void method2(){
        System.out.println("实现类可以重写默认方法也可以不重写默认方法。");
    }

    @Override
    public void method3() {
        System.out.println("抽象方法");
    }
}
