package com.malsolo.springframework.reloaded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	final private static Logger logger = LoggerFactory.getLogger(SimpleBeanFactoryPostProcessor.class);
	
	public SimpleBeanFactoryPostProcessor() {
		logger.warn("Created SimpleBeanFactoryPostProcessor");
	}

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.info("Just in postProcessBeanFactory");
	}

}
