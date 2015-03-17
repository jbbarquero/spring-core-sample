package com.malsolo.springframework.reloaded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanPostProcessor implements BeanPostProcessor {

	final private static Logger logger = LoggerFactory.getLogger(SimpleBeanPostProcessor.class);
	
	public SimpleBeanPostProcessor() {
		logger.warn("Created SimpleBeanPostProcessor");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("Just in postProcessBeforeInitialization for bean: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("Just in postProcessAfterInitialization for bean: " + beanName);
		return bean;
	}

}
