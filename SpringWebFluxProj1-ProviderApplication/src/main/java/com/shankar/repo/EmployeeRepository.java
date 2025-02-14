package com.shankar.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.shankar.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

}
