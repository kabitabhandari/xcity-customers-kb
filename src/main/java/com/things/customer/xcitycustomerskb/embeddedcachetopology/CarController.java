package com.things.customer.xcitycustomerskb.embeddedcachetopology;


import com.things.customer.xcitycustomerskb.Exception.MapIsEmptyException;
import com.things.customer.xcitycustomerskb.Exception.PostmanFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final CacheClient cacheClient;
    Map<String, Car> myMap = new HashMap<>();


    public CarController(CacheClient cacheClient) {
        this.cacheClient = cacheClient;
    }

    @PostMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity PutCarInfoInCache(@RequestBody Car car, @PathVariable String id) {
        cacheClient.put(id, car);
        PostmanFormat yo = new PostmanFormat("Car Info Successfully stored in cache client", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car RetrieveCarInfoFromCache(@PathVariable String id) {
        Optional<Car> result = cacheClient.get(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new MapIsEmptyException("map is empty");
        }
    }


    @PostMapping(path = "hmap/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity carInfo(@RequestBody Car car, @PathVariable String id) {
        myMap.put(id, car);
        PostmanFormat yo = new PostmanFormat("Entry Successfully stored in user created hash map", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }

    @GetMapping(value = "hmap/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car carInfo(@PathVariable String id) {
        return myMap.get(id);
    }
}
