package com.shankar.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.shankar.model.Employee;
@Component
public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee> {
	
@Override
public Employee process(Employee emp) throws Exception {
	if(emp.getSalary()>=5000) {
		emp.setGrossSalary(Math.round(emp.getSalary()+emp.getSalary()*0.4f));
		emp.setNetSalary(Math.round(emp.getSalary()+emp.getSalary()-0.2f));
	}
	return null;
}
}
