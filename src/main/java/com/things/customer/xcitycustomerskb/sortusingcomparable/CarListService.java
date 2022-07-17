package com.things.customer.xcitycustomerskb.sortusingcomparable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Sorting using comparable?
// Sorting using comparator?
// Sorting using stream?

// using comparable
@Service
public class CarListService{

    public List<Car> sortingCars() {
        // Make sure Car class is already implementing Comparable Interface otherwise you get an error while using  Collections.sort(rawList) in line below.
        List<Car> rawList = CarHashMap.listOfCars();

        System.out.println("rawlist before sort (using comparable)  " + rawList);

        Collections.sort(rawList);
        System.out.println("rawlist after sort  (using comparable) " + rawList);



        //Note: with Integer class,it works directly without having to implement anything inside Integer class? No. Because Integer class is by default implementing Comparable Interface. Click and see.
        List<Integer> randomInteger = new ArrayList<>();
        randomInteger.add(3);
        randomInteger.add(13);
        randomInteger.add(43);
        randomInteger.add(33);
        randomInteger.add(23);

        Collections.sort(randomInteger);
        System.out.println("randomInteger after (sorting are)  " + randomInteger);



        return rawList;
    }

}
