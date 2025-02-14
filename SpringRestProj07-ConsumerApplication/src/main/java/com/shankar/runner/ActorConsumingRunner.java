package com.shankar.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class ActorConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
	//create RestTemplate
		RestTemplate template=new RestTemplate();
		//prepare base url
		String baseUrl="http://localhost:3030/SpringRestProj07-ProviderApplication/actor/wish";
		//invoke the response entity object
		//ResponseEntity<String> response=template.getForEntity(baseUrl,String.class);
		//working with exchange method
		ResponseEntity<String> response=template.exchange(baseUrl, HttpMethod.GET, null, String.class);
		System.out.println("body::"+response.getBody());
		System.out.println("status code::"+response.getStatusCodeValue());
		System.out.println("status:::"+response.getStatusCode());
		System.out.println("headers content::"+response.getHeaders());

		
		String result=template.getForObject(baseUrl, String.class);
		System.out.println("result:::"+result);
	}

}
