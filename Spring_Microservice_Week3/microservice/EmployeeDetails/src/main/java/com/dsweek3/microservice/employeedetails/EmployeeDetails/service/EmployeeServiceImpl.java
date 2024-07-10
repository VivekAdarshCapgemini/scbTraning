package com.dsweek3.microservice.employeedetails.EmployeeDetails.service;

import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.APIResponseDto;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.DepartmentDTO;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.dto.EmployeeDTO;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.model.Employee;
import com.dsweek3.microservice.employeedetails.EmployeeDetails.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private APIClient apiClient;

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //    @Override
//    public EmployeeDTO getEmployeeById(int id) {
//        Employee employee = employeeRepository.findById(id).orElse(null);
//        return convertToDTO(employee);
//    }
    @Override
    public APIResponseDto getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        System.out.println(employee.getDepartment());
        List<DepartmentDTO> departmentDtos = apiClient.getDepartment(employee.getDepartment());
        System.out.println("departmentDto: " + departmentDtos);

        DepartmentDTO departmentDto = null;
        if (!departmentDtos.isEmpty()) {
            departmentDto = departmentDtos.get(0); // Retrieve the first department from the list
        }

        EmployeeDTO employeeDto = new EmployeeDTO(
                employee.getId(),
                employee.getDepartment(),
                employee.getName()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDtos);
        return apiResponseDto;
    }

    @Override
    public List<Employee> getEmployeeByName(String employeeName) {
        List<Employee> employee = employeeRepository.findByName(employeeName);
        return employee;
    }

    @Override
    public EmployeeDTO addEmployee(Employee employee) {
        return convertToDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(id)) {
            Employee employee = convertToEntity(employeeDTO);
            employee.setId(id);
            return convertToDTO(employeeRepository.save(employee));
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        if (employee == null) return null;
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDepartment(employee.getDepartment());
        return dto;
    }


    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) return null;
        Employee entity = new Employee();
        entity.setId(employeeDTO.getId());
        entity.setName(employeeDTO.getName());
        entity.setDepartment(employeeDTO.getDepartment());
        return entity;
    }
}
