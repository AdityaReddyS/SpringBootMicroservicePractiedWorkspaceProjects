package com.shankar.streamapi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintFirst10OddNumbers {

	public static void main(String[] args) {
	Stream.iterate(new int[] {1,3}, f -> new int [] {f[1],f[1]+2}).limit(10).map(f->f[0]).forEach(i -> System.out.println(i+" "));
System.out.println("-------------------------------------------------------------------------------");
Stream.iterate(new int[] {1,4}, f -> new int [] {f[1],f[1]+4}).limit(10).map(f->f[1]).forEach(i -> System.out.println(i+" "));
System.out.println("=============================================");
List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");

String lastElement=listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
System.out.println("Last Element="+lastElement);


System.out.println("====================================");

LocalDate birthDay = LocalDate.of(2021,12,13);
LocalDate today = LocalDate.now();
 
System.out.println(ChronoUnit.YEARS.between(birthDay, today));
	}

}
