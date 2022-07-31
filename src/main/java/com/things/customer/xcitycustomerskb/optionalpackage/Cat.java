package com.things.customer.xcitycustomerskb.optionalpackage;

import lombok.Data;

@Data
public class Cat {
    private String name;
    private Integer age;

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
