package com.shankar.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoing {

	public static void main(String[] args) {
		List<String> listofStrings=Arrays.asList("Instagram","Facebook","Twitter","Tiktok","Youtube","Share chat","WeChat","WhatsApp");
		System.out.println(listofStrings);
		System.out.println("----------------------------------------");
		String JoinedString=listofStrings.stream().collect(Collectors.joining(",", "[", "]"));
				
System.out.println(JoinedString);
	}

}
