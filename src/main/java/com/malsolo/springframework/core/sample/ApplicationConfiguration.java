package com.malsolo.springframework.core.sample;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:configuration.properties")
@ComponentScan(basePackageClasses = {ApplicationConfiguration.class})
@EnableTransactionManagement//https://www.youtube.com/watch?list=UU7yfnfvEUlXUIfm8rGLwZdA&feature=player_detailpage&v=-4BQXNufpbQ#t=2010
public class ApplicationConfiguration {
	
	@Autowired
	Environment env;
	
	@Bean(initMethod = "initMethod")
	public CustomService customService() {
		MyCustomService service = new MyCustomService();
		service.setMessage(env.getProperty("configuration.message"));
		service.setDataSource(dataSource());
		return service;
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
	

}
