package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config.xml");

        Employee employee=applicationContext.getBean("employee",Employee.class);

        System.out.println("Employee details: " + employee);

        // Close the Spring context to trigger destruction phase
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}