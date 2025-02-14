package com.shankar.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class BillingServiceRestConsumer {
	@Autowired
	private DiscoveryClient clientcomp;
	public String getBillingInfo() {
//find and get the service instance of producer by using service id
	List<ServiceInstance> listsi=clientcomp.getInstances("Billing-Service");
	ServiceInstance SI=listsi.get(0);
	String url=SI.getUri()+"/billing/info";
	RestTemplate template=new RestTemplate();
	String resp=template.getForObject(url, String.class);
	return resp;
}
}
