package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SpringMsProj10FallbackMethodCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj10FallbackMethodCircuitBreakerApplication.class, args);
	}

}
