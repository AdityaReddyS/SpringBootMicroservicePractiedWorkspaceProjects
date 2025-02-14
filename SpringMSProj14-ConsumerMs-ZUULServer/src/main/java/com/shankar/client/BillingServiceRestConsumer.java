package com.shankar.client;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class BillingServiceRestConsumer {
	@Autowired
	private LoadBalancerClient clientcomp;
	public String getBillingInfo() {
//find and get the service instance of producer by using service id
	
	ServiceInstance SI=clientcomp.choose("Billing-Service");
	
	URI uri=SI.getUri();
	
	String url=uri.toString()+"/billing/info";
	RestTemplate template=new RestTemplate();
	ResponseEntity< String> response=template.getForEntity(url, String.class);
	String result=response.getBody();
	return result;
}
}
