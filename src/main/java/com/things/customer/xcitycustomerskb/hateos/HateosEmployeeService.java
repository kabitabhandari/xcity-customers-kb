package com.things.customer.xcitycustomerskb.hateos;

import com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

// Service interface to specify employee operations to be performed.
@Service
public interface HateosEmployeeService {
    List<HateosEmployee> getAllEmployees();
    HateosEmployee getEmployeeById(Integer id);
    JobDetail getEmployeeByIdUsingJobDetail(Integer id);

}
