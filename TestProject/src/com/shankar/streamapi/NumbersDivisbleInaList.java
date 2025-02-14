package com.shankar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersDivisbleInaList {

	public static void main(String[] args) {
	List<Integer> integers=Arrays.asList(25,45,23,12,55,75,95,20,11,16,18,46);
	integers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);

	}

}
