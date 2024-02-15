package com.example.restapi.DemoRestApi.dto;

import com.example.restapi.DemoRestApi.model.Address;
import com.example.restapi.DemoRestApi.model.Department;
import com.example.restapi.DemoRestApi.model.Employee;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequest {

        @NotBlank
        private String name;

        @Min(18)
        @Max(60)
        private int age;

        @NotNull
        private Department department;

        private Address address;

        public Employee to(String employeeId){

            return Employee.builder()
                    .name(this.name)
                    .age(this.age)
                    .department(this.department)
                    .address(this.address)
                    .updatedOn(System.currentTimeMillis())
                    .id(employeeId)
                    .build();
        }
}
