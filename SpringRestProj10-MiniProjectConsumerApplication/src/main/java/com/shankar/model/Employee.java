package com.shankar.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer empno;
	
	private String ename;
	
	private String job="CLERK";

	private Double sal;
	
	private Integer deptno;
	
	private String status="active";
	

}
