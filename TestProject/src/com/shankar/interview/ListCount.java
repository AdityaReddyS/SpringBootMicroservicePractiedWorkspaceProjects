package com.shankar.interview;

import java.util.Scanner;

public class ListCount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int n=sc.nextInt();
	Integer[] a= {1,4,5,9,8,7,5,4,2,1};
	int count=0;
	for(int i=0;i<a.length;i++) {
		if(a[i] ==n) {
			count++;
			System.out.println("COunt of numbers"+count);
		}
		
	}

	}

}
//sel
//select max(salary) from employee where salary<select max(salary) from employee<select max(salary) from employee<select max(salary) from employee;
