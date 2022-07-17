package com.things.customer.xcitycustomerskb.comparator;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Sorting using comparable?
// Sorting using comparator?
// Sorting using stream?

// using comparator
@Service
public class CarListService2 {
    // You can use any approaches as below:

    public List<Car2> sortingCars2Approach1() {
        List<Car2> rawList = CarHashMap2.listOfCars2();
        System.out.println("rawlist before sort using comparator  " + rawList);

        Collections.sort(rawList, new Comparator<Car2>() {  // .sort will take second paramater as lamda
            @Override
            public int compare(Car2 x, Car2 y) {  // this could be objects of two different classes too.
                if (x.getYear() == y.getYear())
                    return 0;
                else if (x.getYear() > y.getYear())
                    return 1;
                else
                    return -1;
            }

        });
        return rawList;
    }

    public List<Car2> sortingCars2Approach2(){
        List<Car2> rawList2 = CarHashMap2.listOfCars2();
        System.out.println("rawlist before sort using comparator  " + rawList2);

        Collections.sort(rawList2, new Comparator<Car2>() {
            @Override
            public int compare(Car2 x, Car2 y) {
                return x.getModel().compareTo(y.getModel());
            }

        });

        System.out.println("rawlist after sort using comparator   " + rawList2);

        return rawList2;
    }
}
