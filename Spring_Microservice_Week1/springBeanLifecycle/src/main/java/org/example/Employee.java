package org.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("Id Set");
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name set");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(){
        System.out.println("Constructor called");
    }

//    public void init() {
//        System.out.println("Custom init method called.");
//    }
//
//    public void destroy() {
//        System.out.println("Custom destroy method called.");
//    }

    @PostConstruct
    public void init() {
        System.out.println("Employee: @PostConstruct method called.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Employee: @PreDestroy method called.");
    }
}
