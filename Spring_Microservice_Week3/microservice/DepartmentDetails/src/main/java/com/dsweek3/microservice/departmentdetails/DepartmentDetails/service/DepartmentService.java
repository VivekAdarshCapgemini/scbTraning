package com.dsweek3.microservice.departmentdetails.DepartmentDetails.service;

import com.dsweek3.microservice.departmentdetails.DepartmentDetails.dto.DepartmentDTO;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.dto.DepartmentDTO;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.model.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO getDepartmentById(int id);
    List<Department> getDepartmentByName(String departmentName);
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO);
    void deleteDepartment(int id);
}

