package com.reflection;

import java.io.Serializable;

/**
 * com.reflection
 *
 * @author Liuzf
 * @date 2020-06-19 19:56:55
 */
public class Person implements Serializable{


        private String name;
        private int age;

        public Person(String name,int age){
            this.age = age;
            this.name = name;
        }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
