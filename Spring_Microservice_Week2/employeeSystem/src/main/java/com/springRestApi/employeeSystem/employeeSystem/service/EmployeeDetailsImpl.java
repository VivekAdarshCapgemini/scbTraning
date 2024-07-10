package com.springRestApi.employeeSystem.employeeSystem.service;

import com.springRestApi.employeeSystem.employeeSystem.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class EmployeeDetailsImpl implements EmployeeDetailsInterface {

    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    static {
        employees.add(new Employee(1, "ABC", "XYZ", "M", LocalDate.parse("1994-10-17"), "Bangalore"));
        employees.add(new Employee(2, "DEF", "WXY", "F", LocalDate.parse("1992-11-13"), "Pune"));
        employees.add(new Employee(3, "GHI", "YZS", "M", LocalDate.parse("1994-06-14"), "Chennai"));
        employees.add(new Employee(4, "JKL", "TSR", "F", LocalDate.parse("1997-03-16"), "Kolkata"));
        employees.add(new Employee(5, "MNO", "TDG", "M", LocalDate.parse("1993-12-17"), "Bangalore"));
        employees.add(new Employee(6, "PQR", "MDK", "F", LocalDate.parse("1992-04-12"), "Bihar"));
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public ArrayList<Employee> getAllEmployeeDetails() {
        return employees;
    }

    @Override
    public Employee getEmployeeDetails(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;

    }

    @Override
    public void deleteEmployeeDetails(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    @Override
    public void updateEmployeeDetails(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                return;
            }
        }
        System.out.println("Employee with ID " + employee.getId() + " not found. Update failed.");
    }
}
