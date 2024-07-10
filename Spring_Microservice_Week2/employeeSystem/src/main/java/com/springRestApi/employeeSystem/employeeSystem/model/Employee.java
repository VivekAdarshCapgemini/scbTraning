package com.springRestApi.employeeSystem.employeeSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class Employee {

    int id;
    String firstName;
    String lastname;
    String gender;
    LocalDate dob;
    String address;


}
