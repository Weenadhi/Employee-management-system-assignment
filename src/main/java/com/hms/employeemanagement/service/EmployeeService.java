package com.hms.employeemanagement.service;


import com.hms.employeemanagement.dto.EmployeeDTO;
import com.hms.employeemanagement.model.Department;
import com.hms.employeemanagement.model.DepartmentName;
import com.hms.employeemanagement.model.Employee;
import com.hms.employeemanagement.model.EmployeeID;
import com.hms.employeemanagement.repository.DepartmentRepository;
import com.hms.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void createEmployee(EmployeeDTO edto) {

        System.out.println("BBBB");

        Employee employee = new Employee();
        employee.setName(edto.getName());
        employee.setMobileNumber(edto.getMobileNumber());
        employee.setJoinedDate(edto.getJoinedDate());
        employee.setAge(edto.getAge());
        employee.setGender(edto.getGender());
        employee.setDesignation(edto.getDesignation());
        employee.setEmail(edto.getEmail());
        employee.setNic(edto.getNic());


        Optional<Department> department = departmentRepository.findById(edto.getDepartmentID());

        Employee finalemployee=employee;

        System.out.println("CCCCC");

        department.ifPresent(department1 -> {
            EmployeeID primaryKey = new EmployeeID(edto.getEmployeeID(), department1);
            finalemployee.setEmployeeId(primaryKey);
            repository.save(finalemployee);
        });

        System.out.println("DDDDD");
    }

    //Get list of all the employees
    public List<EmployeeDTO> findAll() {
        List<Employee> employeeList = repository.findAllEmp();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.employeeID = employee.getEmployeeId().getEmployeeId();
            employeeDTO.name = employee.getName();
            employeeDTO.age = employee.getAge();
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }

    //

        public List<EmployeeDTO>findEmpByname(String name) {
            List<Employee> employeeList2 = repository.findByName(name);
            List<EmployeeDTO> employeeDTOS = new ArrayList<>();
            for (Employee employee : employeeList2) {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.employeeID = employee.getEmployeeId().getEmployeeId();
                employeeDTO.name = employee.getName();
                employeeDTO.age = employee.getAge();
                employeeDTOS.add(employeeDTO);
            }
            return employeeDTOS;

        }

    public List<EmployeeDTO> findEmpByDepartmentName(String departmentName) {
        List<Employee> employeeList3 = repository.findByDeptName(departmentName);
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employeeList3) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.name = employee.getName();
            employeeDTOS.add(employeeDTO);

        }
        return employeeDTOS;
    }
        public List<EmployeeDTO>findempByNic(String nic) {
            List<Employee> employeeList4 = repository.findByNic(nic);
            List<EmployeeDTO> employeeDTOS = new ArrayList<>();
            for (Employee employee : employeeList4) {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.employeeID = employee.getEmployeeId().getEmployeeId();
                employeeDTO.name = employee.getName();
                employeeDTO.age = employee.getAge();
                employeeDTOS.add(employeeDTO);
            }
            return employeeDTOS;

        }

    public void deleteEmployee(long employeeId,int departmentId)

    {
        repository.deleteById(employeeId,departmentId);
    }

    }






