package com.dsweek3.microservice.employeedetails.EmployeeDetails.controller;

import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.APIResponseDto;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.EmployeeDTO;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.model.Employee;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.repository.EmployeeRepository;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> allEmployeeDetails=employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployeeDetails);
    }

//    @GetMapping("/getEmployeeById/{id}")
//    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
//        EmployeeDTO employeeDetails=employeeService.getEmployeeById(id);
//        return ResponseEntity.ok(employeeDetails);
//    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable int id) {
        APIResponseDto employeeDetails=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDetails);
    }

    @GetMapping("/getEmployeeByName/{employeeName}")
    public ResponseEntity<List<Employee>> getDepartmentById(@PathVariable String employeeName) {
        List<Employee> employeeDetails=employeeService.getEmployeeByName(employeeName);
        return ResponseEntity.ok(employeeDetails);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee) {
       EmployeeDTO savedEmployee= employeeService.addEmployee(employee);
       return new ResponseEntity<EmployeeDTO>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id,employeeDTO);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}
