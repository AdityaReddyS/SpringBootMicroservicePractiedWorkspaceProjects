package com.shankar.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shankar.entiry.Employee;

public class SortByEmployeeList {
	
	public void sortnaturalAlphabets() {
		List<String> alphabets=Arrays.asList("E","M","Z","W","P","R","V");
		
		//List<String> sortedAlphabets=alphabets.stream().sorted().collect(Collectors.toList());
		List<String> sortedAlphabets=alphabets.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		sortedAlphabets.forEach(System.out::println);
		System.out.println("------------------------------------");
		sortedAlphabets.forEach(item->{
			System.out.println(item);
		});
		System.out.println("-----------------------");
		for(String alpha: sortedAlphabets) {
			System.out.println(alpha);
		}
	}
	
	public void sortWithoutUsingLambda() {
	    List<Employee> employees = Arrays.asList(
	       new Employee(1,"George", 25, 10000.0), 
	       new Employee(2,"Robert", 40, 15000.0),
	       new Employee(3,"Kathy", 29, 25000.0)
	    );
	    Comparator<Employee> sortbyname=(e1,e2)->e1.getName().compareTo(e2.getName());
	    Comparator<Employee> sortbysalary=(e1,e2)->Double.compare(e1.getSalary(), e2.getSalary());
	    
	    //sort by name then compare sort by salary
	    employees.stream().sorted(sortbyname.thenComparing(sortbysalary)).forEach(System.out::println);
	 //List<Employee> sortedEmployees=employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getAge)).collect(Collectors.toList());
	    //Collections.sort(employees,Comparator.comparing(Employee::getName));
//employees.sort((Employee e1,Employee e2)->e1.getName().compareTo(e2.getName()));

	 //sortedEmployees.forEach(System.out::println);

//employees.forEach(item->{
//	System.out.println(item);
//});
		/*
		 * Collections.sort(employees, new Comparator<Employee>() {
		 * 
		 * @Override public int compare(Employee e1, Employee e2) { return
		 * e1.getName().compareTo(e2.getName()); } });
		 * 
		 * for(Employee emp : employees) { System.out.println(emp); }
		 */
	}

	public static void main(String[] args) {
		
		SortByEmployeeList sel=new SortByEmployeeList();
		sel.sortWithoutUsingLambda();
		//sel.sortnaturalAlphabets();

	}

}
