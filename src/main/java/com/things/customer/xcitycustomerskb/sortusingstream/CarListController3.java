package com.things.customer.xcitycustomerskb.sortusingstream;

import com.things.customer.xcitycustomerskb.sortusingcomparator.Car2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarListController3 {

    private final CarListService3 service;

    @Autowired
    public CarListController3(CarListService3 service) {
        this.service = service;
    }

    @GetMapping(path = "/get-cars3")
    public List<Car2> getCars() {
        return service.sortingCars3();

    }


}
