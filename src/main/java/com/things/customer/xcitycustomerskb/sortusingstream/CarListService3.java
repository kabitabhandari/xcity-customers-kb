package com.things.customer.xcitycustomerskb.sortusingstream;

import com.things.customer.xcitycustomerskb.sortusingcomparator.Car2;
import com.things.customer.xcitycustomerskb.sortusingcomparator.CarHashMap2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Sorting using comparable?
// Sorting using comparator?
// Sorting using stream?

// using stream --> uses comparator in sorted() in stream.
@Service
public class CarListService3 {

    public List<Car2> sortingCars3() {
        List<Car2> rawList = CarHashMap2.listOfCars2();
        System.out.println("rawlist before sort (using stream) " + rawList);
        List<Car2> sortedList = rawList.stream().sorted(   // stream() takes lamda of Comparator
                new Comparator<Car2>() {
                    @Override
                    public int compare(Car2 x, Car2 y) {
                        if (x.getYear() == y.getYear())
                            return 0;
                        else if (x.getYear() > y.getYear())
                            return 1;
                        else
                            return -1;
                    }
                }
        ).collect(Collectors.toList());


        System.out.println("rawlist after sort (using stream) " + sortedList);
        return sortedList;
    }
}
