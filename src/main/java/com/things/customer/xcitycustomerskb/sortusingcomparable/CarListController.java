package com.things.customer.xcitycustomerskb.sortusingcomparable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarListController {

    private final CarListService service;

    @Autowired
    public CarListController(CarListService service) {
        this.service = service;
    }

    @GetMapping(path = "/get-cars")
    public List<Car> getCars() {
        return service.sortingCars();

    }


}
