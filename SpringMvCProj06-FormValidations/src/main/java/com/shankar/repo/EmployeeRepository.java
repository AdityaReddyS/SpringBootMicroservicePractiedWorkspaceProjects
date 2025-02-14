package com.shankar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shankar.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
