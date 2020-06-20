package com.proxy;

import java.lang.reflect.Proxy;

/**
 * com.proxy
 *
 * @author Liuzf
 * @date 2020-06-19 19:02:32
 */
public class ProxypatternDemo {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        Loghandle log = new Loghandle(userDao);
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),log);
        userDaoProxy.addUser();
    }
}
