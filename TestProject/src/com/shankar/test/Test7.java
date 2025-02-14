package com.shankar.test;

public class Test7 {

	public static void main(String[] args) {
		
System.out.println(reverseOfTheString("Shankar Reddy Bhavani"));
System.out.println(reverseOfTheStringManually("Aditya Reddy Alugubelli"));
	}
public static String  reverseOfTheString(String str) {
	return new StringBuilder(str).reverse().toString();
	
}

public static String reverseOfTheStringManually(String str) {
	StringBuilder sb=new StringBuilder();
	for( int i = str.length()-1;i>=0;i--) {
		sb.append(str.charAt(i));
		
	}
	return sb.toString();
}
}
