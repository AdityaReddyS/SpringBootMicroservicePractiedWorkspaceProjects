package com.shankar.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindThreeMaximumAndMinimumNumbers {

	public static void main(String[] args) {
	List<Integer> listofIntgers=Arrays.asList(45,12,68,78,99,100,256,456,123);
System.out.println("Minimum three Numbers");
listofIntgers.stream().sorted().limit(3).forEach(System.out::println);
System.out.println("Maximum three Numbers");
listofIntgers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}

}
