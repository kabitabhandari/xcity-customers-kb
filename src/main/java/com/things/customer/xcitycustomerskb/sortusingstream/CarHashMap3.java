package com.things.customer.xcitycustomerskb.sortusingstream;

import com.things.customer.xcitycustomerskb.sortusingcomparator.Car2;

import java.util.ArrayList;
import java.util.List;

public class CarHashMap3 {
    public static List<Car2> listOfCars2(){
        List<Car2> myCarsList = new ArrayList<>();
        myCarsList.add(new Car2("Sedan", "Subaru","legacy", 2022,"green"));
        myCarsList.add(new Car2("Sedan", "Toyota","Corolla", 2012,"white"));
        myCarsList.add(new Car2("SUV", "Ford","planet", 2019,"blue"));
        myCarsList.add(new Car2("Sedan", "Chevvy","rockyice", 2001,"red"));
        myCarsList.add(new Car2("Sedan", "Subaru","speeder", 2008,"black"));
        return myCarsList;

    }
}
