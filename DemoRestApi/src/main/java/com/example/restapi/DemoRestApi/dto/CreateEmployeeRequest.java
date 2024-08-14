package com.example.restapi.DemoRestApi.dto;

import com.example.restapi.DemoRestApi.model.Address;
import com.example.restapi.DemoRestApi.model.Department;
import com.example.restapi.DemoRestApi.model.Employee;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder


public class CreateEmployeeRequest {
    private String name;
    private int age;

    private Department department;

    private Address address;
    public Employee to() {
        return Employee.builder() // getting the reference of employeeBuilder class
                .name(this.name) // does not return void, it returns an employeeBuilder
                .age(this.age) // calling the functions of employeeBuilder which returns an object of employeeBuilder
                .address(this.address)
                .department(this.department)
                .createdOn(System.currentTimeMillis())
                .updatedOn(System.currentTimeMillis())
                .id(UUID.randomUUID().toString())
                .build(); // again a function of employeeBuilder which is returning an instance of employee object
    }
}
