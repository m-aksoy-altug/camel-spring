package com.camel.spring.config;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.spring.entity.Course;


@Component
public class FileTransposrt  extends RouteBuilder {
	
	@Autowired
    private CamelContext camelContext;
	
	@Override
	public void configure() throws Exception {
		camelContext.getShutdownStrategy().setTimeout(10);
		JacksonXMLDataFormat xmlDataFormat = new JacksonXMLDataFormat();
		xmlDataFormat.setUnmarshalType(Course.class);		
        String source= "/home/altug/Desktop/eclipse-aws-spring/camel-spring/src/main/resources";
        
        from("file:"+source+"?fileName=course.xml&noop=true") 
        .routeId("xml-to-json")
	    .process(exchange -> log.info("\n\nProcessing file\n\n"+exchange.getIn().getBody()))
	    .doTry()
	        .unmarshal(xmlDataFormat) 
	        .process(exchange -> log.info("\n\n\nUnmarshalled Course\n\n"+exchange.getIn().getBody()))
	        .to("jpa:com.camel.spring.entity.Course")
	    .doCatch(Exception.class)
	    	.process(exchange -> log.info("Error processing file "))
	    .end();
		
	}
	
	
	
//	@Override
//	public void configure() throws Exception {
//		
//		 camelContext.getShutdownStrategy().setTimeout(10);
//		 
//		JacksonXMLDataFormat xmlDataFormat = new JacksonXMLDataFormat();
//        JacksonDataFormat jsonDataFormat = new JacksonDataFormat();				
//    	String source= "/home/altug/Desktop/eclipse-aws-spring/camel-spring/src/main/resources";
//
//	
//	 from("file:"+source+"?fileName=text.xml&noop=true")
//      .routeId("xml-to-json")
//	    .process(exchange -> log.info("\n\nProcessing file\n\n"+exchange.getIn().getBody()))
//	    .doTry()
//	        .unmarshal(xmlDataFormat) 
//	        .marshal(jsonDataFormat) 
//	        .to("file:"+source+"?fileName=text.json") 
//	        .process(exchange -> log.info("Converted XML to JSON"))
//	    .doCatch(Exception.class)
//	    	.process(exchange -> log.info("Error processing file "))
//	        .to("file:"+source+"?fileName=invalid.xml") 
//	    .end();
//		
//	}

}
