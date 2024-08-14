package com.Teams.TeamsApiDemo.Controller;

import com.Teams.TeamsApiDemo.Model.Employee;
import com.Teams.TeamsApiDemo.Service.EmployeeService;
import com.Teams.TeamsApiDemo.dto.CreateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return employeeService.create(createEmployeeRequest);

    }
}
