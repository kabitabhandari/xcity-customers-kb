package com.things.customer.xcitycustomerskb.service;

import com.things.customer.xcitycustomerskb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "employee-cache")
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDAO.insertEmployees(employees);
    }

    @Override
    @Cacheable()
    public List<Employee> getAllEmployees() {
        System.out.println("Database call started...\n");
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void getEmployeeById(String empId) {
        Employee employee = employeeDAO.getEmployeeById(empId);
        System.out.println(employee);
    }
}
