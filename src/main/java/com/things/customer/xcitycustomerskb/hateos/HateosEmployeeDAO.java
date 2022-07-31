package com.things.customer.xcitycustomerskb.hateos;

import java.util.List;

public interface HateosEmployeeDAO {
    List<HateosEmployee> getAllEmployees();

    HateosEmployee getEmployeeById(Integer id);

    JobDetail getEmployeeByIdUsingJobDetail(Integer id);
}
