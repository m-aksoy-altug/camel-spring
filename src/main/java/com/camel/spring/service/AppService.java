package com.camel.spring.service;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.support.builder.Namespaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.spring.entity.Course;
import com.camel.spring.repo.CourseRepo;

import jakarta.xml.bind.JAXBContext;

@Service
public class AppService {

	private static final Logger log = LoggerFactory.getLogger(AppService.class);

	@Autowired
	CamelContext camelContext;
	
	@Autowired
	CourseRepo courseRepo;

	public void sendRandomValue() {

//		try {
//			camelContext.addRoutes(new RouteBuilder() {
//				JacksonXMLDataFormat xmlDataFormat = new JacksonXMLDataFormat();
//		        JacksonDataFormat jsonDataFormat = new JacksonDataFormat();				
//		    
//				@Override
//				public void configure() {
////					String source= "/home/altug/Desktop/eclipse-aws-spring/camel-spring/src/main/resources";
//					String source ="/home/altug/Desktop";
//					String dest ="/home/altug/Desktop/JAVA";	
//				
//				
//				 from("file:"+source+"?fileName=text.xml&noop=true") // Watch "input" folder for XML files
//		          .routeId("xml-to-json")
//				    .process(exchange -> log.info("\n\nProcessing file\n\n"+exchange.getIn().getBody()))
//				    .doTry()
//				        .unmarshal(xmlDataFormat) // Convert XML to Java Object
//				        .marshal(jsonDataFormat) // Convert Java Object to JSON
//				        .to("file:"+source+"?fileName=text.json") // Save as JSON
//				        .process(exchange -> log.info("Converted XML to JSON"))
//				    .doCatch(Exception.class)
//				    	.process(exchange -> log.info("Error processing file "))
////				        .log("Error processing file ${file:name}: ${exception.message}")
//				        .to("file:"+dest+"?fileName=invalid.xml") 
//				    .end();
//				
////				.to("jpa:com.camel.spring.entity.Course");
////				from("direct:start")
//////				.process(exchange -> exchange.getIn()
//////						.setBody("{\"title\":\"KafkaTest 21\",\"body\":\"Virtual Thread\",\"userId\":\"1\"}"))
//////				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
////				.setBody(constant("Sending to Kafka"))
////				.setHeader(KafkaConstants.KEY, constant("Camel"))
////				.to("kafka:my-topic?brokers=127.0.0.1:9094");
//////				.to("kafka:my-topic?brokers=kafka1:9092");
////				// https://rmoff.net/2018/08/02/kafka-listeners-explained/
//			}
//			});
//
//			camelContext.start();
//
//			log.info("context.getRoutes()" + camelContext.getRoutes().toString());
//			log.info("context.getStatus()" + camelContext.getStatus().toString());
//			Thread.sleep(1000);
//			camelContext.stop();
//
//		} catch (Exception e) {
//			log.info("ERROR" + e.getMessage());
//			log.error("ERROR" + e.getMessage());
//			e.printStackTrace();
//		}
	}
	
	
	public List<Course> getAllCOurseData() {
		List<Course> all= courseRepo.findAll();
		log.info("all" + all.toString());
		return all;
	}

}
