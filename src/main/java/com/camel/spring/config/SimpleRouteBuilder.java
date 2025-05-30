//package com.camel.spring.config;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.apache.camel.CamelContext;
//import org.apache.camel.Exchange;
//import org.apache.camel.LoggingLevel;
//import org.apache.camel.Processor;
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.kafka.KafkaConstants;
//import org.apache.camel.impl.DefaultCamelContext;
//import org.apache.camel.main.Main;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//public class SimpleRouteBuilder extends RouteBuilder{
//	
//	// chmod -R g+rwX /home/altug/Desktop/kafkacontainer 
//	private static final Logger log= LoggerFactory.getLogger(SimpleRouteBuilder.class);
//	@Override
//	public void configure() throws Exception {
//		try(CamelContext context=new DefaultCamelContext();) {
////			ExecutorService executor = Executors.newFixedThreadPool(10);
//			context.addRoutes(new RouteBuilder() {
//				@Override
//				public void configure() {
//					from("timer://foo?period=1000")
////					.doTry()
//					.process(new MyProcessor())
//					.setHeader(KafkaConstants.KEY, constant("Camel"))
//					
//					.process(exchange -> log.info("Setting headers:"+ 
//							  exchange.getIn().getHeaders()))
//					.process(exchange -> log.info("Setting body:"+ 
//							  exchange.getIn().getBody()))
//					.to("kafka:my-topic?brokers=192.168.1.113:9094");
////					.doCatch(Exception.class)
////					.process(new Processor() {
////						@Override
////						public void process(Exchange exchange) throws Exception{
////							log.info("Handling Exception");
////						}
////					});
//					
//		
//			        from("kafka:my-topic?brokers=192.168.1.113:9094")
//			    	.process(exchange -> log.info("FROM KAFKA headers:"+ 
//							  exchange.getIn().getHeaders()))
//					.process(exchange -> log.info("FROM KAFKA body:"+ 
//							  exchange.getIn().getBody()));
//				}
//			});
//		
//			context.start();
//			
//			log.info("context.getRoutes()"+context.getRoutes().toString());
//			log.info("context.getStatus()"+context.getStatus().toString());
//			Thread.sleep(1000*600);
//			context.stop();
////			main.run();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		
//		}
//		
//	}
//
//
//}
