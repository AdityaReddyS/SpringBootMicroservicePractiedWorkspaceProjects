package com.shankar.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shankar.model.Employee;

import reactor.core.publisher.Mono;
//@Component
public class GetEmployeeByIdTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		WebClient client=WebClient.create("http://localhost:4041/SpringWebFluxProj1/");
		
		Mono<Employee> mono=client.get().uri("/employee/findbyid/10001").retrieve().bodyToMono(Employee.class);
		mono.subscribe(System.out::println);

	}

}
