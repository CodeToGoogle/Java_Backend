package com.Teams.TeamsApiDemo.Service;

import com.Teams.TeamsApiDemo.Model.Employee;
import com.Teams.TeamsApiDemo.Repository.EmployeeRepository;
import com.Teams.TeamsApiDemo.dto.CreateEmployeeRequest;
import lombok.Builder;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Builder
@Service
public class EmployeeService {



List<Employee> employeeList=new ArrayList<>();

    public Employee create(CreateEmployeeRequest createEmployeeRequest) {
        Employee e=CreateEmployeeRequest.to(createEmployeeRequest);
        employeeList.add(e);
        return e;

    }
}
