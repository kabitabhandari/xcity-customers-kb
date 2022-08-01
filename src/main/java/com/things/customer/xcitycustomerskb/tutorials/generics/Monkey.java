package com.things.customer.xcitycustomerskb.tutorials.generics;

public class Monkey {

    public String name;
    public int age;

    public Monkey() {
    }

    public Monkey(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

