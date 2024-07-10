package com.dsweek3.microservice.employeedetails.EmployeeDetails.service;

import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.APIResponseDto;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.EmployeeDTO;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
   // EmployeeDTO getEmployeeById(int id);
    List<Employee> getEmployeeByName(String employeeName);
    EmployeeDTO addEmployee(Employee employee);
    EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
    APIResponseDto getEmployeeById(int id);
}

