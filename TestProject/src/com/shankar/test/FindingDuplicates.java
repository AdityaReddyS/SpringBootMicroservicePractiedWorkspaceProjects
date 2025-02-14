package com.shankar.test;

import java.util.Scanner;

//finding the number of vowels in a String

public class FindingDuplicates {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.next();
		int count=0;
		for(int i=0;i< str.length();i++) {
		char	ch=str.charAt(i);
			if( ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o'|| ch == 'u') {
				count++;
			}
		}
		System.out.println("no of vowels count::"+count);
	}

}
