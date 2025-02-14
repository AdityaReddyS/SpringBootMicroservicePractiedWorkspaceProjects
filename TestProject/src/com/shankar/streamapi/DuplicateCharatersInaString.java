package com.shankar.streamapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharatersInaString {

	public static void main(String[] args) {
		String inputstr="Java Concept of the day".replaceAll("\\s","").toLowerCase();
		
		Set<String> uniquechars=new HashSet();
		Set<String> duplicatechars=Arrays.stream(inputstr.split("")).filter(ch -> ! uniquechars.add(ch)).collect(Collectors.toSet());
System.out.println(duplicatechars);
	}

}
