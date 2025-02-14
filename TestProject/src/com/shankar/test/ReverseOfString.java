package com.shankar.test;

public class ReverseOfString {

	
	public static String reverseString(String s) {
		//take the character array to store the String
		char[] charArray=s.toCharArray();
		//intialise the variables
		int left=0;
		int right=charArray.length-1;
		for(int i=0;i<right;i++)
		if(left < right) {
			char temp=charArray[left];
			charArray[left]=charArray[right];
			charArray[right]=temp;
			left++;
			right--;
		}
		return new String(charArray);
		
	}
	
	
	
	public static void main(String[] args) {
		String str=" hello";
		System.out.println(reverseString(str));

	}

}
