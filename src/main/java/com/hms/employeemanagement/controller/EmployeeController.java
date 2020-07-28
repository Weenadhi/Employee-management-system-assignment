package com.hms.employeemanagement.controller;

import com.hms.employeemanagement.dto.EmployeeDTO;
import com.hms.employeemanagement.model.Employee;
import com.hms.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allemp")
    public List<EmployeeDTO> show() {
        return employeeService.findAll();
    }

    @GetMapping("/empByName")
    public List<EmployeeDTO> showByName(@RequestParam("name") String name) {
        return employeeService.findEmpByname(name);
    }

    @GetMapping("/empByDept")
    public List<EmployeeDTO> showByDept(@RequestParam("departmentName") String departmentName) {
        return employeeService.findEmpByDepartmentName(departmentName);
    }

    @GetMapping("/empByNic")
    public List<EmployeeDTO> showByNic(@RequestParam("nic") String nic) {
        return employeeService.findempByNic(nic);
    }

    @DeleteMapping("/delEmpByID")
    public String deleteEmployee(@RequestParam("employeeId") long employeeId, @Param("departmentId") int departmentId) {
        employeeService.deleteEmployee(employeeId, departmentId);
        return "Employee deleted successfully";

    }

    @PostMapping("/addEmployee")
    public String createNewEmployee(@RequestBody EmployeeDTO employee) {
        System.out.println("AAAAAA");
        employeeService.createEmployee(employee);
        System.out.println("222222222222");
        return "Employee successfully added";

    }



}
