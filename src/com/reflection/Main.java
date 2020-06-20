package com.reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * com.reflection
 *
 * @author Liuzf
 * @date 2020-06-19 19:58:14
 */
public class Main {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("luoxn28", 23);
        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);

            System.out.println(key + ":" + value);

        }
    }
}
