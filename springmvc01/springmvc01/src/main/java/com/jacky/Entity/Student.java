package com.jacky.Entity;

import org.springframework.stereotype.Component;

public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("无参构造Student对象");
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
