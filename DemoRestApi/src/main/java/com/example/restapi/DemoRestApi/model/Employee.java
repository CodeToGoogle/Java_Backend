package com.example.restapi.DemoRestApi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Employee {


    private String id; // which is given to the employee
    private String name;
    private int age;
    private Department department;
    private Address address;
    private Long createdOn;
    private Long updatedOn;




}
