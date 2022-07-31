package com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall;

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
    public void insertEmployee(Employee employee, Integer id) {
        employeeDAO.insertEmployee(employee, id);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDAO.insertEmployees(employees);
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("Database call started...\n");
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        System.out.println(employee);
        return employee;
    }

    @Cacheable()
    @Override
    public List<Employee> getAllEmployeesFromCache() {
        return getAllEmployees();
    }
}
