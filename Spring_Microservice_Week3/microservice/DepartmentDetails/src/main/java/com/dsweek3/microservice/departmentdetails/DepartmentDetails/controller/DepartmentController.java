package com.dsweek3.microservice.departmentdetails.DepartmentDetails.controller;

import com.dsweek3.microservice.departmentdetails.DepartmentDetails.dto.DepartmentDTO;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.model.Department;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        List<DepartmentDTO> allDepartmentDetails=departmentService.getAllDepartment();
        return ResponseEntity.ok(allDepartmentDetails);
    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable int id) {
        DepartmentDTO departmentDetails=departmentService.getDepartmentById(id);
        System.out.println("departmentDetails "+departmentDetails);
        return ResponseEntity.ok(departmentDetails);
    }

    @GetMapping("/getDepartmentByDepartment/{departmentName}")
    public ResponseEntity<List<Department>> getDepartmentById(@PathVariable String departmentName) {
        List<Department> departmentDetails=departmentService.getDepartmentByName(departmentName);
        System.out.println("departmentDetails "+departmentDetails);
        return ResponseEntity.ok(departmentDetails);
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        System.out.println("departmentDTO "+departmentDTO);
       DepartmentDTO savedDepartment= departmentService.addDepartment(departmentDTO);
       return new ResponseEntity<DepartmentDTO>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/updateDepartment/{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody DepartmentDTO departmentDTO) {
        departmentService.updateDepartment(id,departmentDTO);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }
}
