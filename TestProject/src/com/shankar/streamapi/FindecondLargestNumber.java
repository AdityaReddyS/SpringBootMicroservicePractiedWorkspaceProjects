package com.shankar.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindecondLargestNumber {

	public static void main(String[] args) {
		List<Integer> listofIntgers=Arrays.asList(11,25,36,45,89,78,69,110,235);

		Integer seclargets=listofIntgers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(seclargets);
	}

}
