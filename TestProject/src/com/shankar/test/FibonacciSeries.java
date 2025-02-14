package com.shankar.test;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
	
		int a=0;int b=1;
		int sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int num=sc.nextInt();
	
			System.out.println(a);
			System.out.println(b);
			for(int i=0;i<num;i++) {
			sum=a+b;
			a=b;
			b=sum;
		System.out.println(+sum);
			}
		
	}

}
