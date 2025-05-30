package com.camel.spring.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camel.spring.entity.Course;
import com.camel.spring.service.AppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@CrossOrigin
//@RequestMapping("/dummy")
public class SpringController {
	
	private static final Logger log = LoggerFactory.getLogger(SpringController.class);
	
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired
	private AppService appService;
	
	@GetMapping(path="/dummy",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ObjectNode> senddata() {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode responseNode = objectMapper.createObjectNode();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String json =  "{\"date\":\"failed\"}";
		HashMap<String, String> responseHashMap = new HashMap<String, String>();
	
		try {
			List<String> result = null;
			try {
				appService.sendRandomValue();
				responseHashMap.put("Sending random value","to Kafka");
				responseHashMap.put("Local IP Address",request.getLocalAddr());
				responseHashMap.put("Local Name",request.getLocalName());
				responseHashMap.put("Local Protocal",request.getProtocol());
				responseHashMap.put("Local Port",request.getLocalPort()+"");
				responseHashMap.put("Remote IP Address",request.getRemoteAddr());
				responseHashMap.put("Remote Host",request.getRemoteHost());
				responseHashMap.put("Remote Port",request.getRemotePort()+"");
				responseHashMap.put("Server Name",request.getServerName());
				json = objectMapper.writeValueAsString(responseHashMap);
				log.info("Json:" + json.toString());
			} catch (Exception e) {
				log.error("Error occur" + e.getLocalizedMessage());
			}
			JsonNode node = objectMapper.readTree(json);
			return new ResponseEntity<>((ObjectNode) node, headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((ObjectNode) responseNode, headers, HttpStatus.BAD_REQUEST);
		}

	}

	
	
	@GetMapping(path="/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObjectNode> getdata() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		try {
			List<Course> all = appService.getAllCOurseData();
			 String jsonString = objectMapper.writeValueAsString(all);
			ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(jsonString);
			JsonNode jsonNode= objectMapper.createObjectNode().set("Result", arrayNode);
			log.info("node:::"+jsonNode);
			return new ResponseEntity<>((ObjectNode) jsonNode, headers, HttpStatus.OK);
		} catch (Exception e) {
			String json =  "{\"error\":\"failed\"}";
			JsonNode errorNode = objectMapper.readTree(json);
			return new ResponseEntity<>((ObjectNode) errorNode, headers, HttpStatus.BAD_REQUEST);
		}

	}

}	
