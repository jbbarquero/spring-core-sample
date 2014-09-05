package com.malsolo.springframework.core.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
	
	@Autowired
	CustomService customService;
	
	public static void main(String... args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		info(context);
		Main main = context.getBean(Main.class);
                System.out.println("***** Running CustomService *********");
		main.customService.run();
                System.out.println("***** Info from CustomService *********");
                main.customService.info();
                System.out.println("***** No more lyrics *********");
		context.close();
	}
	
	private static void info(ApplicationContext context) {
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("***** Loaded beans *********");
		for (String beanName : beanNames) {
			Object beanInstance = context.getBean(beanName);
			System.out.printf(">>>>> Bean name: %s. Class: %s\n", beanName, beanInstance.getClass().getName());
		}
		System.out.println("***** END Loaded beans *********");
	}

}
