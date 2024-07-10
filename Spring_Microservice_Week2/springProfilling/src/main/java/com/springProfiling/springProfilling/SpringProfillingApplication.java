package com.springProfiling.springProfilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProfillingApplication implements CommandLineRunner {
	@Autowired
	MyService myService;
	@Autowired
	private ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(SpringProfillingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		displayBeans();
		myService.doSomething();
		checkDevMyServiceBean();
	}

	public void displayBeans() {
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("Bean Name: " + beanName);
		}
	}

	public void checkDevMyServiceBean() {
		String[] beanNames = context.getBeanNamesForType(DevMyService.class);
		if (beanNames.length > 0) {
			String beanName = beanNames[0];
			System.out.println("DevMyService bean exists with bean name: " + beanName);
		} else {
			System.out.println("DevMyService bean does not exist");
		}
	}


}
