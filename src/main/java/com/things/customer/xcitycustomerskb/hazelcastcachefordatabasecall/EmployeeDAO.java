package com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall;

import java.util.List;
public interface EmployeeDAO  {
    void insertEmployee(Employee emp, Integer id);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
}
