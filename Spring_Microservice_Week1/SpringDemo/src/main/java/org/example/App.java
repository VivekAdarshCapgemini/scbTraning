package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("constructorInjection.xml");

        BankEmployee employee = (BankEmployee) context.getBean("bankEmployee");

        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Skills: " + employee.getSkills());
        System.out.println("Employee Achievements: " + employee.getAchievements());


    }
}
