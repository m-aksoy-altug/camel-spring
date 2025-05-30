package com.camel.spring.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String x= "Sending to Kafka: ";
		Random r = new Random();
		int low = 1;
		int high = 100000;
		int result = r.nextInt(high-low) + low;
		
        exchange.getIn().setBody(x+result, String.class);
	}

}
