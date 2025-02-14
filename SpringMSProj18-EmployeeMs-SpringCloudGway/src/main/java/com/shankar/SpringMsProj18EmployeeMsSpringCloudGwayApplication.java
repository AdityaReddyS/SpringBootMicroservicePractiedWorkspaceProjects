package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsProj18EmployeeMsSpringCloudGwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj18EmployeeMsSpringCloudGwayApplication.class, args);
	}

}
