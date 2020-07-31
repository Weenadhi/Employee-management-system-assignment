package com.hms.employeemanagement;

import com.hms.employeemanagement.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
		EmployeeService empService=new EmployeeService();
		empService.doStuff("Spring application running");
	}

}
