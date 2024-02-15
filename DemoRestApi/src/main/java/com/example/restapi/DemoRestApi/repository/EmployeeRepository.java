package com.example.restapi.DemoRestApi.repository;

import com.example.restapi.DemoRestApi.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    HashMap<String,Employee> employeeMap=new HashMap<>();
    public Employee create(Employee employee) {

        employeeMap.put(employee.getId(),employee);
        return employee;
    }
    public Employee get(String id) {
//        return employeeMap.getOrDefault(id, null);
        return employeeMap.get(id);
    }
    public List<Employee> get(){
        return employeeMap
                .values()
                .stream()
                .collect(Collectors.toList());

    }
    public Employee updated(Employee employee){
        Employee existingEmployee=employeeMap.get(employee.getId()); //getting the employee id from the employee table which has been inserted through controllers --> dto using builder
        if(existingEmployee !=null){
            employee= merge(existingEmployee,employee); //merging the existing data and the new data together
            employeeMap.put(employee.getId(), employee);
        }
        return employee;
    }
    private Employee merge(Employee oldData, Employee newData){
        newData.setCreatedOn(oldData.getCreatedOn());
        return newData;
    }
    public Employee delete(String employeeId) {
        return employeeMap.remove(employeeId);
    }
}
