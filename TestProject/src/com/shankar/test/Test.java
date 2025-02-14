package com.shankar.test;


public class Test {

	public static void main(String[] args) {
int a=27061994;
while(a/10!=0) {
	int sum=0,c;
	while(a!=0) {
		c=a/10;
		 sum =a%10+sum;
		 a=c;
	}
a=sum;
}
System.out.println("Your Lucky Number is"+a);
}
}
	
	

