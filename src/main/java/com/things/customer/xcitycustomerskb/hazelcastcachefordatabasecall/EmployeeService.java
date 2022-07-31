package com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall;

import org.springframework.stereotype.Service;

import java.util.List;

// Service interface to specify employee operations to be performed.
@Service
public interface EmployeeService {
    void insertEmployee(Employee emp, Integer id);

    void insertEmployees(List<Employee> employees);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployeesFromCache();
}
