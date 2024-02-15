package com.example.restapi.DemoRestApi.controller;

import com.example.restapi.DemoRestApi.dto.CreateEmployeeRequest;
import com.example.restapi.DemoRestApi.dto.UpdateEmployeeRequest;
import com.example.restapi.DemoRestApi.model.Employee;
import com.example.restapi.DemoRestApi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    //mvc architecture
    //Controller--Service--Repository--(Data layer/Model)
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody @Valid CreateEmployeeRequest request) {
        return employeeService.create(request);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String id) {
        return employeeService.get(id);
    }

    @GetMapping("/employee/all")
    public List<Employee> getEmployee() {
        return employeeService.get();
    }

    @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") String employeeId,
                                   @RequestBody @Valid UpdateEmployeeRequest request) {
        return employeeService.update(employeeId, request);
    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestParam("id") String employeeId) {
        return employeeService.delete(employeeId);

    }
}
