package com.shankar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachElementInArray {

	public static void main(String[] args) {
		List<String> stationaryList=Arrays.asList("Pen","Pencil","Eraser","Sharpner","Book","Pen","Pencil","Sharpner","Book","Water Bottle");
		
		Map<String, Long> stacount=stationaryList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(stacount);

	}

}
