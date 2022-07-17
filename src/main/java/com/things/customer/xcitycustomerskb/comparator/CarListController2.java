package com.things.customer.xcitycustomerskb.comparator;

import com.things.customer.xcitycustomerskb.comparable.Car;
import com.things.customer.xcitycustomerskb.comparable.CarListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarListController2 {

    private final CarListService2 service;

    @Autowired
    public CarListController2(CarListService2 service) {
        this.service = service;
    }

    @GetMapping(path = "/get-cars2")
    public List<Car2> getCars() {
        return service.sortingCars2Approach2();

    }


}
