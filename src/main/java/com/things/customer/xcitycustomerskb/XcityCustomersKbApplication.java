package com.things.customer.xcitycustomerskb;

import com.things.customer.xcitycustomerskb.config.VaultConfig;
import com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall.Employee;
import com.things.customer.xcitycustomerskb.hazelcastcachefordatabasecall.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableConfigurationProperties(VaultConfig.class)
public class XcityCustomersKbApplication implements CommandLineRunner {
    private static EmployeeService employeeService;
    private final VaultConfig vaultConfig;
	Logger logger = LoggerFactory.getLogger(XcityCustomersKbApplication.class);

    @Autowired
    public XcityCustomersKbApplication(VaultConfig vaultConfig, EmployeeService employeeService) {
        this.vaultConfig = vaultConfig;
        XcityCustomersKbApplication.employeeService = employeeService;
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(XcityCustomersKbApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        Employee emp = new Employee();
        emp.setId(200);
        emp.setFirstName("orange");
        emp.setLastName("walker");

        Employee emp1 = new Employee();
        emp1.setId(201);
        emp1.setFirstName("pumkin");
        emp1.setLastName("jumper");

        Employee emp2 = new Employee();
        emp2.setId(202);
        emp2.setFirstName("grapes");
        emp2.setLastName("runner");


        //employeeService.insertEmployee(emp);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
       // employeeService.insertEmployees(employees);

		System.out.println("______________________________________");
        System.out.println("Attempting to make a call  to DataBase");
		System.out.println("______________________________________");
//        List<Employee> employeeList1 = employeeService.getAllEmployees();
//        for (Employee employee : employeeList1) {
//            System.out.println(employee);
//        }

		System.out.println("_______________________________");
        System.out.println("Attempting to Fetch from Cache");
		System.out.println("_______________________________\n");
//        List<Employee> employeeList2 = employeeService.getAllEmployees();
//        for (Employee employee : employeeList2) {
//            System.out.println(employee);
//        }

		System.out.println("\n");

    }


    @Override
    public void run(String... args) {
        logger.info("----------------------------------------");
        logger.info("Configuration properties");
        logger.info("		example.username is {}", vaultConfig.getUsername());
        logger.info("		example.password is {}", vaultConfig.getPassword());
        logger.info("----------------------------------------");
    }
}
