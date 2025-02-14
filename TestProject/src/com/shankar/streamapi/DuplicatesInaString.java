package com.shankar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicatesInaString {

	public static void main(String[] args) {
		List<String> listofString=Arrays.asList("Java","Python","C",".Net","Php","Java","Python","C","SAP");
		List<String> listofuniqueStrings=listofString.stream().distinct().collect(Collectors.toList());
		System.out.println(listofuniqueStrings);

	}

}
