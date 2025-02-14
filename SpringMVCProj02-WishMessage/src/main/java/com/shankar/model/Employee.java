package com.shankar.model;

public class Employee {
	
	private Integer eno;
	private String ename;
	private String eddrs;
	private Double salary;
	private String dept;
	public Employee(int eno,String ename,String eddrs,double salary,String dept) {
		this.eno=eno;
		this.ename=ename;
		this.eddrs=eddrs;
		this.salary=salary;
		this.dept=dept;
		System.out.println("Employee.Employee()");
	}
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEddrs() {
		return eddrs;
	}
	public void setEddrs(String eddrs) {
		this.eddrs = eddrs;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eddrs=" + eddrs + ", salary=" + salary + ", dept="
				+ dept + "]";
	}

}
