package com.things.customer.xcitycustomerskb.comparable;

import lombok.Data;

import java.io.Serializable;

@Data
public class Car  implements Serializable, Comparable<Car> {
    //Note: Since we have access to this car class, we are making it extend Comparable Interface when we need it, but what if this class was only readable and not writeable?
    // Think? may be use comparator in such case?
    private String type;
    private String make;
    private String model;
    private Integer year;
    private String color;

    public Car(String type, String make, String model, Integer year, String color) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(Car car) {
        return this.year.compareTo(car.year);
    }

    /**
     *     When to use Comparable?
     *
     *     Use Comparable: if the object is in your control.
     *                     if the comparing behaviour is the main comparing behaviour.
     *
     *     Use Comparator : if the object is outside your control and you cannot make them implement Comparable.
     *                     when you want comparing behaviour different from the default (which is specified by Comparable) behaviour.
     *
     *
     * Comparable should be used when you compare instances of the same class.
     * Comparable is implemented by the class which needs to define a natural ordering for its objects. For example, String implements Comparable.
     *
     * Comparator can be used to compare instances of different classes.
     * In case a different sorting order is required, then, implement comparator and define its own way of comparing two instances.
     */

}

