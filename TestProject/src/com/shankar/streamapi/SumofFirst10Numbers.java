package com.shankar.streamapi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumofFirst10Numbers {

	public static void main(String[] args) {
	int sum=IntStream.range(1, 12).sum();
	System.out.println("Sum of first 10 numbers::"+sum);

	int[] array = new int[] {5, 1, 7, 3, 9, 6};
	
	int[] reverse=IntStream.rangeClosed(1,array.length).map( i -> array[array.length-i]).toArray();
	System.out.println(Arrays.toString(reverse));
	
	IntStream.rangeClosed(1,20).map( i -> i * 19).forEach(System.out::println);
	}

}
