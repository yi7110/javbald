package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * com.proxy
 *
 * @author Liuzf
 * @date 2020-06-19 18:58:03
 */
public class Loghandle implements InvocationHandler {

    private Object object;
    public Loghandle(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始记录日志");
        method.invoke(object,args);
        System.out.println("结束记录日志");
        return null;
    }
}
