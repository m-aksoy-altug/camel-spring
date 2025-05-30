package com.camel.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


@Configuration
public class DataSourceConfiguration {
	
	private static final Logger log= LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource() {
//		jdbc:h2:file:~/sample;INIT=RUNSCRIPT FROM '~/create.sql'\;RUNSCRIPT FROM '~/populate.sql'
		DriverManagerDataSource dataSource = new DriverManagerDataSource();		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:~/data/demo2");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
//		Resource  initShema = new ClassPathResource("db/h2/schema.sql");
//		Resource initData = new ClassPathResource("db/h2/data.sql");
//		DatabasePopulator databasepopulator= new ResourceDatabasePopulator(initShema,initData);
//		DatabasePopulatorUtils.execute(databasepopulator, dataSource);
		return dataSource;
	}


}