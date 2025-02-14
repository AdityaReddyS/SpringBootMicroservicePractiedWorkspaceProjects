package com.shankar.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shankar.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
	//type cadting with model object
		
		Employee emp=(Employee) target;
		
		//form validation logic in server side
		if(emp.getEname()==null ||emp.getEname().isBlank()) {
			errors.rejectValue("ename", "emp.ename.required");
		}
		else if(emp.getEname().length()<5 ||emp.getEname().length()>=15) {
			errors.rejectValue("ename", "emp.ename.length");
		}
	
	if(emp.getJob()==null ||emp.getJob().isBlank()) {
		errors.rejectValue("job", "emp.job.required");
	}
	else if(emp.getJob().length()<5 ||emp.getJob().length()>=15) {
		errors.rejectValue("job", "emp.job.length");
	}
	if(!errors.hasFieldErrors("sal")) {
	if(emp.getSal()==null )
		errors.rejectValue("sal", "emp.sal.required");
	
	else if(emp.getSal()<10000 ||emp.getSal()>1000000)
		errors.rejectValue("sal", "emp.sal.range");
	}
	if(emp.getDeptno()==null ) {
		errors.rejectValue("deptno", "emp.deptno.required");
	}
}

}
