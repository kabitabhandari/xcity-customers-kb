package com.things.customer.xcitycustomerskb.generics;

public class Rabbit extends Animal {

    public String name;
    public int age;

    public Rabbit() {
        super("Rain Forest");
    }

    public Rabbit(String name, int age) {
        super("Rain Forest");
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Rabbit{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

