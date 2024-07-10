package org.cg.week1;

import org.cg.week1.model.Employee;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        int x=200;
        int y=200;

        System.out.println("Check1 "+(x==y));

        Employee employee1 = new Employee(1, "John Doe", "123 Main St2334");
        Employee employee2 = new Employee(2, "Jane Smith", "456 Elm St");
        Employee employee3 = new Employee(1, "John Doe", "123 Main St1"); // Duplicate of employee1

        Employee employee4=null;

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);
        employeeSet.add(employee3);

        System.out.println("Employee1 Hashcode "+employee1.hashCode());
        System.out.println("Employee2 Hashcode "+employee2.hashCode());
        System.out.println("Employee3 Hashcode "+employee3.hashCode());

        System.out.println("Check "+employee1.equals(employee3));

        System.out.println("Number of employees in the set: " + employeeSet.size());
        for (Employee employee : employeeSet) {
            System.out.println(employee);
        }
    }
}
