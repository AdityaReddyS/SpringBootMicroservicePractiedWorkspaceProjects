package com.shankar.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DecimalsListInreverseOrder {

	public static void main(String[] args) {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        List<Integer> integersList = Arrays.asList(12, 23, 17, 42, 33, 71, 56, 21);
     decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
     System.out.println("-------------------------------------------");
     integersList.stream().sorted().forEach(System.out::println);
     System.out.println("-------------------------------------------");
     integersList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

}
