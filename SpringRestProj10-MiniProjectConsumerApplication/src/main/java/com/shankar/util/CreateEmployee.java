package com.shankar.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shankar.model.Employee;

@Component
public class CreateEmployee {
	public String saveCustomer(Employee e) {
		String baseUrl="http://localhost:3030/SpringRestProj06-MiniProjectAPIApplication/emp-api/register";
	ObjectMapper om=new ObjectMapper();
	String json;
	Integer s=0;
		try {
			json = om.writeValueAsString(e); 
			
			RestTemplate rest=new RestTemplate();
			 HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_JSON );
		        HttpEntity request= new HttpEntity(json, headers );
		        s=rest.postForObject(baseUrl, request, Integer.class);
		       
			   }catch(Exception ex){
				   ex.printStackTrace();
			   }
	return "Employee is Saved";
	}
}
