package com.shankar.runner;



import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class ActorConsumingRunnerSendingObjectData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
	//create RestTemplate
		RestTemplate template=new RestTemplate();
		//prepare base url
		String baseUrl="http://localhost:3030/SpringRestProj07-ProviderApplication/actor/wish/register";
		//prepare json data
		String json_data="{\"aid\":1001,\"aname\":\"Prabhas\",\"aaddrs\":\"Hyderabad\",\"salary\":15000.0}";
		//prepare headers
		HttpHeaders headers=new HttpHeaders();
		//set media type
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare http request as http entity object
		HttpEntity<String> request=new HttpEntity<String>(json_data,headers);
		//make the http request call in the method
		//ResponseEntity<String> response=template.postForEntity(baseUrl, request, String.class);
		ResponseEntity<String> response=template.exchange(baseUrl, HttpMethod.POST, request,String.class);
		
		System.out.println("body::"+response.getBody());
		System.out.println("status code::"+response.getStatusCodeValue());
		System.out.println("status:::"+response.getStatusCode());
		System.out.println("headers content::"+response.getHeaders());
	}

}
