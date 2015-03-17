package com.malsolo.springframework.reloaded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.malsolo.springframework.core.sample.Main;

@Configuration
@PropertySource("classpath:printer.properties")
//@ComponentScan
public class Application {

	final private static Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	private Environment environment;

	@Bean
	public MessageService messageService() {
		return new SimpleMessageServiceImpl(
				environment.getProperty("printer.message"));
	}

	@Bean
	public MessagePrinter messagePrinter() {
		return new MessagePrinterWithMessageServiceImpl(messageService());
	}

	public static void main(String[] args) {
		boolean xml = false;
		if (args.length > 0) {
			xml = Boolean.valueOf(args[0]);			
		}
		ApplicationContext context = null;
		if (!xml) {
			context = new AnnotationConfigApplicationContext(Application.class);
		} else {
			context = new ClassPathXmlApplicationContext(
					"META-INF/spring/applicationContext.xml");
		}
		info(context);
		MessagePrinter printer = context.getBean("messagePrinter",
				MessagePrinter.class);
		printer.printMessage();
		((ConfigurableApplicationContext) context).close();
	}

	private static void info(ApplicationContext context) {
		logger.info("INFO");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String[] beanNames = context.getBeanDefinitionNames();
		System.err.println("***** Loaded beans *********");
		for (String beanName : beanNames) {
			Object beanInstance = context.getBean(beanName);
			System.err.printf("· Bean name: %s. Class: %s\n", beanName,
					beanInstance.getClass().getName());
		}
		System.err.println("***** END Loaded beans *********");
		logger.info("INFO. END.");
	}

}
