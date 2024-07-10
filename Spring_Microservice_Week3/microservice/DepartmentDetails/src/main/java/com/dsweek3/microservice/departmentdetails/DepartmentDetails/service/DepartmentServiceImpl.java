package com.dsweek3.microservice.departmentdetails.DepartmentDetails.service;

import com.dsweek3.microservice.departmentdetails.DepartmentDetails.repository.DepartmentRepository;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.dto.DepartmentDTO;
import com.dsweek3.microservice.departmentdetails.DepartmentDetails.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> employees = departmentRepository.findAll();
        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(int id) {
        Department employee = departmentRepository.findById(id).orElse(null);
        return convertToDTO(employee);
    }

    @Override
    public List<Department> getDepartmentByName(String departmentName) {
        List<Department> departments = departmentRepository.findByDepartment(departmentName);
        return departments;
    }


    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        System.out.println("department "+department);
        departmentRepository.save(department);
        System.out.println(department);
        return convertToDTO(department);
    }

    @Override
    public DepartmentDTO updateDepartment(int id, DepartmentDTO employeeDTO) {
        if (departmentRepository.existsById(id)) {
            Department employee = convertToEntity(employeeDTO);
            employee.setId(id);
            return convertToDTO(departmentRepository.save(employee));
        }
        return null;
    }

    @Override
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    private DepartmentDTO convertToDTO(Department department) {
        if (department == null) return null;
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setDepartmentCode(department.getDepartmentCode());
        dto.setDepartment(department.getDepartment());
        return dto;
    }

    private Department convertToEntity(DepartmentDTO departmentDTO) {
        System.out.println("Inside ConvertToEntity "+departmentDTO);
        if (departmentDTO == null) return null;
        Department entity = new Department();
        entity.setId(departmentDTO.getId());
        entity.setDepartmentCode(departmentDTO.getDepartmentCode());
        entity.setDepartment(departmentDTO.getDepartment());
        return entity;
    }
}
