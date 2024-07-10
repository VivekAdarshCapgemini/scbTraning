package com.dsweek3.microservice.departmentdetails.DepartmentDetails.repository;

import com.dsweek3.microservice.departmentdetails.DepartmentDetails.dto.DepartmentDTO;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByDepartment(String departmentName);
}
