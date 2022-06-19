package com.things.customer.xcitycustomerskb.service;

import com.things.customer.xcitycustomerskb.model.Employee;

import java.util.List;
// Service interface to specify employee operations to be performed.
public interface EmployeeService {
    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    void getEmployeeById(String empid);
}
