package com.shankar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class SeparateOddAndEvenNumbersInArray {

	public static void main(String[] args) {
		
		List<Integer> listofIntegers=Arrays.asList(11,12,45,44,25,24,28,29,98,99,77,45,63,36,96);
		
		Map<Boolean,List<Integer>> oddevennumbersMap=listofIntegers.stream().collect(Collectors.partitioningBy(i-> i % 2 == 0));
		Set<Entry<Boolean,List<Integer>>> entryset=oddevennumbersMap.entrySet();
		for(Entry<Boolean,List<Integer>> entry :entryset) {
			System.out.println("-------------------------------");
			if(entry.getKey()) {
				System.out.println("Even Numbers");
			}
			else {
				System.out.println("Odd Numbers");
			}
			System.out.println("--------------------------------");
			List<Integer> list=entry.getValue();
			for(int i :list) {
				System.out.println(i);
			}
		}
	}
}
