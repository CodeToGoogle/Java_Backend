package com.example.restapi.DemoRestApi.service;

import com.example.restapi.DemoRestApi.dto.CreateEmployeeRequest;
import com.example.restapi.DemoRestApi.dto.UpdateEmployeeRequest;
import com.example.restapi.DemoRestApi.model.Employee;
import com.example.restapi.DemoRestApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(CreateEmployeeRequest createEmployeeRequest) {
        //takes argument as dto request and converts it into model/entity
        //this dto layer is called by the service layer which interacts with the model/entity
        Employee employee=createEmployeeRequest.to(); //calling the dto layer where conversion is happening from DTO-->Model
        return employeeRepository.create(employee); // will return employee after calling the function with employee details

    }
    public Employee get(String id){

        return employeeRepository.get(id);
    }
    public List<Employee> get(){
        return employeeRepository.get();
    }
    public Employee update(String employeeId, UpdateEmployeeRequest request){
        Employee employee=request.to(employeeId);
        return employeeRepository.updated(employee);
    }
    public Employee delete(String employeeId) {
        return employeeRepository.delete(employeeId);
    }

}
