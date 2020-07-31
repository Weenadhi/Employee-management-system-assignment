package com.hms.employeemanagement.controller;

import com.hms.employeemanagement.dto.EmployeeDTO;
import com.hms.employeemanagement.model.Employee;
import com.hms.employeemanagement.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    EmployeeService employeeService;

    @GetMapping ("/")
    public String homePage(ModelMap modelMap)
    {
        List<EmployeeDTO> employeelist= employeeService.findAll();
        modelMap.addAttribute("dateFormat",dateFormat);
        modelMap.addAttribute("employees",employeelist);
        LOGGER.info("Get all employee list");
        return "index";
    }

    @GetMapping("/register")
    public  String showRegisterPage( @ModelAttribute("employee") EmployeeDTO employee){

        return "register";
    }


    @PostMapping("/addEmployee")
    public String register(@ModelAttribute("employee") EmployeeDTO employee, BindingResult result, ModelMap model){
        employeeService.createEmployee(employee);
        List<EmployeeDTO> emplist=employeeService.findAll();
        model.addAttribute("dateFormat",dateFormat);
        model.addAttribute("employees",emplist);
        return "index";
    }


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

    @GetMapping("/delEmpByID" +
            "")
    public String deleteEmployee(@RequestParam("employeeId") long employeeId, @Param("departmentId") int departmentId) {

        employeeService.deleteEmployee(employeeId, departmentId);
        return "redirect:/";
    }



    @GetMapping("/update/{employeeID}")
    public String showPageUpdate(@PathVariable("employeeID") long employeeID,ModelMap modelMap) {
        EmployeeDTO employeeDTO = employeeService.findEmployeeByEmployeeID(employeeID);
        modelMap.addAttribute("employee",employeeDTO);
        modelMap.addAttribute("dateFormat",dateFormat);
        return "update";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") EmployeeDTO employee,ModelMap modelMap) {
        employeeService.createEmployee(employee);

        modelMap.addAttribute("employee",employee);
        modelMap.addAttribute("dateFormat",dateFormat);

        return "redirect:/update/" + employee.getEmployeeID();

    }

}
