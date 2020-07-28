package com.checkpoint.controller;

import com.checkpoint.entity.Employee;
import com.checkpoint.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.setEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        return service.deleteEmployeeById(id);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployeeById(@RequestBody Employee employee) {
        return service.updateEmployeeById(employee);
    }
}
