package com.things.customer.xcitycustomerskb.service;

import com.things.customer.xcitycustomerskb.model.Employee;

import java.util.List;
public interface EmployeeDAO  {
    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
}
