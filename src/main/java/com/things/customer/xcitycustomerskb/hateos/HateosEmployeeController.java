package com.things.customer.xcitycustomerskb.hateos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hateos")
public class HateosEmployeeController {
    private final HateosEmployeeService employeeService;

    @Autowired
    public HateosEmployeeController(HateosEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HateosEmployee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping(value = "v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HateosEmployee getOneEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }


    @GetMapping(value = "v1/job-detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JobDetail getOneEmployeeJobDetail(@PathVariable Integer id) {
        return employeeService.getEmployeeByIdUsingJobDetail(id);
    }

}
