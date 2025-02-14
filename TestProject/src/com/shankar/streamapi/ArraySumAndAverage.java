package com.shankar.streamapi;

import java.util.Arrays;
import java.util.List;

public class ArraySumAndAverage {

	public static void main(String[] args) {
		  int[] a = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
		  int sum=Arrays.stream(a).sum();
		  System.out.println("Sum of the Array Of numbers="+sum);
Double avg=Arrays.stream(a).average().getAsDouble();
System.out.println("Average Of the Numbers="+avg);

List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
list1.stream().filter(list2 :: contains).forEach(System.out::println);
	}

}
