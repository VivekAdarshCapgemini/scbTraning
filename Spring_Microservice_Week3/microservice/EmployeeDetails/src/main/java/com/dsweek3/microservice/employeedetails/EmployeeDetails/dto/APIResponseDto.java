package com.dsweek3.microservice.employeedetails.EmployeeDetails.dto;

// APIResponseDto.java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDTO employee;
    private List<DepartmentDTO> department;
}
