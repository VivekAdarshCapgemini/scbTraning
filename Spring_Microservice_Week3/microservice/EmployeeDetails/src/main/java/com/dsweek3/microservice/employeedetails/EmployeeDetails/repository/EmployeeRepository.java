package com.dsweek3.microservice.employeedetails.EmployeeDetails.repository;

import com.dsweek3.microservice.employeedetails.EmployeeDetails.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String employeeName);

}
