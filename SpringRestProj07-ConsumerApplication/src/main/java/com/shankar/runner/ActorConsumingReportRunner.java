package com.shankar.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shankar.entity.Actor;
@Component
public class ActorConsumingReportRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
	//create RestTemplate
		
		//prepare base url
		String baseUrl="http://localhost:3030/SpringRestProj07-ProviderApplication/actor/wish/report";
		//invoke the response entity object
		//ResponseEntity<String> response=template.getForEntity(baseUrl,String.class);
		ResponseEntity<String> response=template.exchange(baseUrl,HttpMethod.GET, null,String.class);
		System.out.println("body::"+response.getBody());
		System.out.println("status code::"+response.getStatusCodeValue());
		System.out.println("status:::"+response.getStatusCode());
		System.out.println("headers content::"+response.getHeaders());

		
		String jsonBody=response.getBody();
		ObjectMapper mapper=new ObjectMapper();
		List<Actor> list=mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {});
		list.forEach(System.out::println);
		
		  System.out.println("----------------------"); 
		 for(Actor a:list) {
		  System.out.println(a);
		  } 
		 System.out.println("--------------");
		 list.forEach(ac ->{ System.out.println(ac); });
		 
	}

}
