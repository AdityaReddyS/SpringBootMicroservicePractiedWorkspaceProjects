package com.shankar.test;

public class Test8 {

	public static void main(String[] args) {
	int a=10,b=20,t;
	System.out.println(a+"----------"+b);
t=a;
a=b;
b=t;
System.out.println(a+"---------"+b);
System.out.println("Addition="+(a+b));
System.out.println("Subtraction="+(b-a));

String str="test"+1+2+3;
System.out.println(str);
	}

}
