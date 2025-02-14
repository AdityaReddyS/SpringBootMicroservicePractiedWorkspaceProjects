package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsProj18SpringCloudGatewayApplication {

	
	@Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){ 
        return routeLocatorBuilder.routes() 
                        .route("EMPLOYEE-SERVICE",r->r.path("/employee-api/**") 
                                .uri("http://localhost:8081/")) 
                        .route("CUSTOMER-SERVICE",r->r.path("/customer-api/**") 
                                .uri("http://localhost:8082/")).build(); 
    } 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj18SpringCloudGatewayApplication.class, args);
		
		
	}

}
