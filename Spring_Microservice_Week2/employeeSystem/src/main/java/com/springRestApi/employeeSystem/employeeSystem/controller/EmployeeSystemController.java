package com.springRestApi.employeeSystem.employeeSystem.controller;

import com.springRestApi.employeeSystem.employeeSystem.model.Employee;
import com.springRestApi.employeeSystem.employeeSystem.service.EmployeeDetailsImpl;
import com.springRestApi.employeeSystem.employeeSystem.service.EmployeeDetailsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employeeSystem")
public class EmployeeSystemController {

    @Autowired
    private final EmployeeDetailsInterface employeeService;

    public EmployeeSystemController(EmployeeDetailsImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployeeDetails")
    public ResponseEntity<ArrayList<Employee>> getAllEmployees() {
        ArrayList<Employee> allEmployees = employeeService.getAllEmployeeDetails();
        return allEmployees.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/employeeDetails/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetails(id));
    }

    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employeeService.add(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employeeDetails/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.updateEmployeeDetails(employee);
       return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employeeDetails/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeDetails(id);
        return ResponseEntity.ok(employeeService.getEmployeeDetails(id));
    }


    @PatchMapping("/patchEmployeeDetails/{id}")
    public ResponseEntity<?> patchEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = employeeService.getEmployeeDetails(id);

        if (existingEmployee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with ID: " + id);
        }

        // Update only the fields that are present in the updatedEmployee
        if (updatedEmployee.getFirstName() != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
        }
        if (updatedEmployee.getLastname() != null) {
            existingEmployee.setLastname(updatedEmployee.getLastname());
        }
        if (updatedEmployee.getGender() != null) {
            existingEmployee.setGender(updatedEmployee.getGender());
        }
        if (updatedEmployee.getDob() != null) {
            existingEmployee.setDob(updatedEmployee.getDob());
        }
        if (updatedEmployee.getAddress() != null) {
            existingEmployee.setAddress(updatedEmployee.getAddress());
        }

        // Update the employee details in the service
        employeeService.updateEmployeeDetails(existingEmployee);

        return ResponseEntity.ok(existingEmployee);
    }


}

