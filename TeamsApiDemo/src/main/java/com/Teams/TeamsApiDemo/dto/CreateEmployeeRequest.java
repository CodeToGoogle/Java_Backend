package com.Teams.TeamsApiDemo.dto;

import com.Teams.TeamsApiDemo.Model.Employee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequest {
 private int id;

 private String name;

 public static Employee to(CreateEmployeeRequest e){
    return Employee.builder()
            .id(e.id)
            .name(e.name)
             .build();
    }
}
