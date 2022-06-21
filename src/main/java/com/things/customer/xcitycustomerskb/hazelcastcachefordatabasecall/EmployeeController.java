package com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall;

import com.things.customer.xcitycustomerskb.Exception.PostmanFormat;
import com.things.customer.xcitycustomerskb.embeddedcachetopology.CacheClient;
import com.things.customer.xcitycustomerskb.embeddedcachetopology.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {



    @PostMapping(path = "cache/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putUsingHazelCastCache(@RequestBody Car car, @PathVariable String number) {
        employeeService.insertEmployee(emp);



        PostmanFormat yo = new PostmanFormat("Entry Successful", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }

    @GetMapping(value = "cache/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getUsingHazelCastCache(@PathVariable String number) {
        return cacheClient.get(number);
    }

}
