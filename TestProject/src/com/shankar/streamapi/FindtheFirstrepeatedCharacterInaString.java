package com.shankar.streamapi;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindtheFirstrepeatedCharacterInaString {

	public static void main(String[] args) {
		String input="Java Concept of the Day".replaceAll("\\s+","").toLowerCase();
		
		Map<String,Long> charcount=Arrays.stream(input.split("")).
				collect(Collectors.groupingBy(Function.identity(),LinkedHashMap :: new ,Collectors.counting()));
		String firstrepeatedCharcter=charcount.entrySet().stream().
				filter(entry -> entry.getValue() > 1).
				map(entry -> entry.getKey()).
				findFirst().get();
System.out.println(firstrepeatedCharcter);
	}

}
