package com.intv.apptwo.service;

import java.util.Arrays;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.intv.apptwo.vo.ServiceResponse;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class ConsumerServiceImpl {
	
	@Value("${greeting.url}")
	private String greetingUrl;
	
	@Value("${internal.greeting.url}")
	private String internalGreetingUrl;
	
	@Qualifier(value="restTemplate")
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consume/greetings",method=RequestMethod.GET)
	@ApiOperation(value = "Greets everyone", response = ServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 406, message = "Exception from public greeting"),
			@ApiResponse(code = 200, message = "Sucess") })
	public @ResponseBody ServiceResponse getMessage(){
			
		return restTemplate.getForObject(greetingUrl,ServiceResponse.class);
			
	}
	
	

}
