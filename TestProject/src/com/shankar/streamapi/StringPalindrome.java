package com.shankar.streamapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringPalindrome {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("One", "two", "3hree", "4our", "5ive", "Six");
	    
	    listOfStrings.stream()
	    .filter(str->Character.isDigit(str.charAt(0))).forEach(System.out::println);
	    
	    
	    List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements =listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());
        System.out.println(duplicateElements);
	    
		String str="abcdcba";
		Boolean isItPalindrome=IntStream.range(0, str.length() / 2).noneMatch(i ->
		str.charAt(i) !=str.charAt(str.length()-i-1));
		if(isItPalindrome) {
			System.out.println(str+  "Is Palindrome");
		}
		else {
			System.out.println(str+ "Not a Palindrome");
		}
	}
	

}


