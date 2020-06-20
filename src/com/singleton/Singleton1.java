package com.singleton;

import com.company.Singleton;

/**
 * com.sington
 * 双重检验饿汉式单例模式
 * @author Liuzf
 * @date 2020-06-19 15:33:35
 */
public class Singleton1 {
    private Singleton1(){}
    private volatile static Singleton1 instance = null;
    public Singleton1 getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
