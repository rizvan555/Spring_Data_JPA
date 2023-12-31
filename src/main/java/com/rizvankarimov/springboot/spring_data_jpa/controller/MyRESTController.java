package com.rizvankarimov.springboot.spring_data_jpa.controller;


import com.rizvankarimov.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private com.rizvankarimov.springboot.spring_data_jpa.service.EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }


    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployees(@PathVariable String name){
        List<Employee> allEmployeesByName = employeeService.findByName(name);
        return allEmployeesByName;
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> showAllEmployeesByDepartment(@PathVariable String department){
        List<Employee> allEmployeesByDepartment = employeeService.findByDepartment(department);
        return allEmployeesByDepartment;
    }
}

