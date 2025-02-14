package com.shankar.streamapi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachwordInaString {

	public static void main(String[] args) {
		String str ="Java Concept of the day";
		String reverseStr=Arrays.stream(str.split(" ")).map(word->  new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
	System.out.println("Reverse Word of a String::"+reverseStr);
	}
}
