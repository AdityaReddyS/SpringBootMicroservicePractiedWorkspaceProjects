package com.shankar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document(collection = "EMPLOYEE_USERS")
@Data
public class Employee {
	@Id
private Integer id;
private String ename;
private String eaddrs;
private Double salary;
}
