package com.things.customer.xcitycustomerskb.embeddedcachetopology;


import com.things.customer.xcitycustomerskb.Exception.PostmanFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final CacheClient cacheClient;
    Map<String, Car> myMap = new HashMap<>();


    public CarController(CacheClient cacheClient) {
        this.cacheClient = cacheClient;
    }

    @PostMapping(path = "cache/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putUsingHazelCastCache(@RequestBody Car car, @PathVariable String number) {
        cacheClient.put(number, car);
        PostmanFormat yo = new PostmanFormat("Entry Successful", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }

    @GetMapping(value = "cache/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getUsingHazelCastCache(@PathVariable String number) {
        return cacheClient.get(number);
    }
    @PostMapping(path = "hmap/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity regularPut(@RequestBody Car car, @PathVariable String number) {
        myMap.put(number, car);
        PostmanFormat yo = new PostmanFormat("Entry Successful", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }

    @GetMapping(value = "hmap/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car regularGet(@PathVariable String number) {
        return myMap.get(number);
    }
}
