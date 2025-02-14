package com.shankar.streamapi;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharactersCountInaString {

	public static void main(String[] args) {
		String inputString="Welcome to Java Hyderabad";
		
		Map<Character,Long> charcount=inputString.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(charcount);

	}

}
