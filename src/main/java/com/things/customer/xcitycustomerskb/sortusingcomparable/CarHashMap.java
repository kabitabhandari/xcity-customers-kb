package com.things.customer.xcitycustomerskb.sortusingcomparable;

import java.util.ArrayList;
import java.util.List;

public class CarHashMap {
    public static List<Car> listOfCars() { // TODO Play with instance/static
        List<Car> myCarsList = new ArrayList<>();
        myCarsList.add(new Car("Sedan", "Subaru", "legacy", 2022, "green"));
        myCarsList.add(new Car("Sedan", "Toyota", "Corolla", 2012, "white"));
        myCarsList.add(new Car("SUV", "Ford", "planet", 2019, "blue"));
        myCarsList.add(new Car("Sedan", "Chevvy", "rockyice", 2001, "red"));
        myCarsList.add(new Car("Sedan", "Subaru", "speeder", 2008, "black"));
        return myCarsList;

    }
}
