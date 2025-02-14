package com.shankar.test;

public class StringPalindrome {

	public static boolean isPalindrome(String str) {
		
		//convert the given string into lower case
		str=str.toLowerCase();
		if(str.length()==0 || str ==null) {
			return true;
		}
		for(int i=0;i< str.length() / 2;i++) {
			char start=str.charAt(i);
			char end=str.charAt(str.length() -1 -i);
			if(start !=end) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
	String str="abcygcba";
	System.out.println(isPalindrome(str));

	}

}
