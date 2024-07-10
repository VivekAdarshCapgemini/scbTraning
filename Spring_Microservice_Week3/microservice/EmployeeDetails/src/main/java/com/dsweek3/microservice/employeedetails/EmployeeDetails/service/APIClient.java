package com.dsweek3.microservice.employeedetails.EmployeeDetails.service;

// APIClient.java
import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "DepartmentDetails", url = "http://localhost:8081")
public interface APIClient {
    @GetMapping("/api/departments/getDepartmentByDepartment/{departmentName}")
    List<DepartmentDTO> getDepartment(@PathVariable("departmentName") String departmentName);

}