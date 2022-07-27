package com.things.customer.xcitycustomerskb.sortusingcomparator;

import lombok.Data;

@Data
public class Car2 {
    //Note: Assume you cannot modify this class
    private String type;
    private String make;
    private String model;
    private Integer year;
    private String color;

    public Car2(String type, String make, String model, Integer year, String color) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
}

