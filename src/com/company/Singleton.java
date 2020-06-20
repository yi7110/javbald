package com.company;

/**
 * 饿汉式单例模式加双重校验
 * @author Liuzf
 */
public class Singleton {
    private Singleton(){}
    private static volatile Singleton instance = null;
    public Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
