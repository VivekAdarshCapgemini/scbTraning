package com.springRestApi.employeeSystem.employeeSystem.service;

import com.springRestApi.employeeSystem.employeeSystem.model.Employee;

import java.util.ArrayList;

public interface EmployeeDetailsInterface {

    void add(Employee employee);
    ArrayList<Employee> getAllEmployeeDetails();
    Employee getEmployeeDetails(int id);
    void deleteEmployeeDetails(int id);
    void updateEmployeeDetails(Employee employee);

}
