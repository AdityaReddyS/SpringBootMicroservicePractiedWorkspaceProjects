package com.shankar.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
private Integer id;
private String ename;
private String eaddrs;
private Double salary;
}
