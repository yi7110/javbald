package com.reflection;

/**
 * com.reflection
 *
 * @author Liuzf
 * @date 2020-06-19 20:17:19
 */
public class Student {

    private String name;

    private Integer age;

    public Student() {

    }

    public Student(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
