package com.shankar.streamapi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindingSumOfAllDigits {

	public static void main(String[] args) {
	int num=931995;

	Integer sumofDigit=Stream.of(String.valueOf(num).split("")).collect(Collectors.summingInt(Integer :: parseInt));
	System.out.println(sumofDigit);
	}

}
