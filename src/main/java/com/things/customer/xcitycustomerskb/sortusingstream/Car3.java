package com.things.customer.xcitycustomerskb.sortusingstream;

import lombok.Data;

@Data
public class Car3 {
    //Note: Assume you cannot modify this class
    private String type;
    private String make;
    private String model;
    private Integer year;
    private String color;

    public Car3(String type, String make, String model, Integer year, String color) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
}

