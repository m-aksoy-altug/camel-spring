package com.camel.spring;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.camel.spring.entity.Course;
import com.camel.spring.repo.CourseRepo;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class SpringbootApp {
	
	private static final Logger log= LoggerFactory.getLogger(SpringbootApp.class);
	// clean spring-boot:run || clean install
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApp.class,args);
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	CourseRepo courseRepo;
	
	@PostConstruct
	public void intProcess() {
		try {
			if(dataSource !=null) {
				JdbcTemplate template= new JdbcTemplate();
				template.setDataSource(dataSource);
				log.info("\n\nCONNECTION IS DONE\n\n");
//				initDatabaseUsingSpring();
			}else {
				throw new NullPointerException();
			}
			
		} catch (Exception e) {
	    	log.info("intProcess()"+e.getMessage());
			log.debug("intProcess()"+e.getMessage());
			log.error("intProcess()"+e.getMessage());
		}
	}
	
//	public void initDatabaseUsingSpring() {
//	    try {
//	    	Course c= new Course();
//	    	c.setCourseId(1);
//	    	c.setCourseName("spring");
//	    	c.setDuration(24);
//	    	Course saved=courseRepo.save(c);
//	    	log.error("\n\n"+saved.toString());
//	    }
//	    catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
	
//	public void initDatabaseUsingSpring(DataSource ds) {
//		
//	    try (Connection conn = ds.getConnection()) {
//	    	Boolean result0= conn.createStatement().execute("drop table if exists course;");
//	    	if(result0!=true) {
//	    		 log.error("\n\ndrop table if exists course\\n\\n");
//	    	 }
//	    	Boolean result= conn.createStatement().execute("create table course (courseId INT PRIMARY KEY NOT NULL, courseName VARCHAR(100) NOT NULL, duration int NOT NULL);");
//	    	 if(result!=true) {
//	    		 log.error("\n\nNot inserted\\n\\n");
//	    	 }
//	    	 Boolean result2=conn.createStatement().execute("insert into course (courseId, courseName,duration) values (1, 'dummy',12)");
//	    	 if(result2!=true) {
//	    		 log.error("\n\nNot inserted\\n\\n");
//	    	 }
//	    	 conn.createStatement().execute("insert into course (courseId, courseName,duration) values (2, 'camel',12)");
//	    	 conn.createStatement().execute("insert into course (courseId, courseName,duration) values (3, 'spring',12)");
//	    	 conn.createStatement().execute("insert into course (courseId, courseName,duration) values (4, 'kafka',12)");
//	    }
//	    catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
}
