package com.shankar.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shankar.model.Employee;

import reactor.core.publisher.Mono;
//@Component
public class SaveCommandLineTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//1. Create web client
		WebClient client=WebClient.create("http://localhost:4041/SpringWebFluxProj1/");
//2. Method,Path,URI,retrive-type
		Mono<Employee> mono=client.post().uri("/employee/save").
				body(Mono.just(new Employee(10001, "Shankar Reddy", "Bengaluru", 90000.0)),Employee.class).
				retrieve().bodyToMono(Employee.class);
		mono.subscribe(System.out::println);
				
	}

}
