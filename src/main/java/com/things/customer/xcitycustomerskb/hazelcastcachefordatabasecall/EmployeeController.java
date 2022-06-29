package com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall;

import com.things.customer.xcitycustomerskb.Exception.PostmanFormat;
import com.things.customer.xcitycustomerskb.embeddedcachetopology.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "v1/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postOneEmployeeRecord(@RequestBody Employee employee, @PathVariable Integer id ) {
        employeeService.insertEmployee(employee, id);
        PostmanFormat yo = new PostmanFormat("One Record Inserted in H2 Database", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }
    @PostMapping(path = "v1", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postListOfEmployeeRecords(@RequestBody List<Employee> employee) {
        employeeService.insertEmployees(employee);
        PostmanFormat yo = new PostmanFormat("List of Records Inserted in H2 Database", String.valueOf(HttpStatus.CREATED.value()));
        return new ResponseEntity<>(yo, HttpStatus.valueOf(201));
    }

    @GetMapping(value = "v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping(value = "v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getOneEmployee(@PathVariable Integer id ) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "v1/cache", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getFromCache() {
        return employeeService.getAllEmployeesFromCache();
    }

}
