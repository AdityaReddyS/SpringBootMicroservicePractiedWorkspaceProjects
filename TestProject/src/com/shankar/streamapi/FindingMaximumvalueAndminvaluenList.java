package com.shankar.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindingMaximumvalueAndminvaluenList {

	public static void main(String[] args) {
		List<Integer> integers=Arrays.asList(25,45,23,12,55,75,95,20,11,16,18,46);
int max=integers.stream().max(Comparator.naturalOrder()).get();
System.out.println("Maximun Value="+max);

int min=integers.stream().min(Comparator.naturalOrder()).get();
System.out.println("Minimum Value="+min);
	}

}
