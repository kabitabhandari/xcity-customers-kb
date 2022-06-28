package com.things.customer.xcitycustomerskb.hateos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HateosEmployeeServiceImpl implements HateosEmployeeService {
    private final HateosEmployeeDAO employeeDAO;


    @Autowired
    public HateosEmployeeServiceImpl(HateosEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<HateosEmployee> getAllEmployees() {
        System.out.println("Database call started...\n");
        return employeeDAO.getAllEmployees();
    }

    @Override
    public HateosEmployee getEmployeeById(Integer id) {
        HateosEmployee employee = employeeDAO.getEmployeeById(id);
        System.out.println(employee);
        return employee;
    }

    @Override
    public JobDetail getEmployeeByIdUsingJobDetail(Integer id) {
        JobDetail detail = employeeDAO.getEmployeeByIdUsingJobDetail(id);
        return detail;
    }
}
