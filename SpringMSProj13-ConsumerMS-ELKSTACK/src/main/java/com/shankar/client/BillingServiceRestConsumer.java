package com.shankar.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class BillingServiceRestConsumer {
	@Autowired
	private LoadBalancerClient clientcomp;
	public String getBillingInfo() {
//find and get the service instance of producer by using service id
	log.info("method is started for execution");
	ServiceInstance SI=clientcomp.choose("Billing-Service");
	log.info("getting the Service Instance of Producer By Using Service id");
	URI uri=SI.getUri();
	log.info("Preparing the Uri to invoke the provide Ms");
	String url=uri.toString()+"/billing/info";
	log.info("url is Prepared");
	RestTemplate template=new RestTemplate();
	ResponseEntity< String> response=template.getForEntity(url, String.class);
	log.info("response object is created to invoke the url and the type of data ");
	String result=response.getBody();
	log.info("result is prepared");
	return result;
}
}
