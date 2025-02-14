package com.shankar.streamapi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysMergetwoUnSortedArrays {

	public static void main(String[] args) {
	int[] a=new int[] {1,9,5,3,3,7};
	int[] b=new int[] {2,4,6,9,8,10};
	int[] c=IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
	System.out.println(Arrays.toString(c));
	int[] d=IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
	System.out.println(Arrays.toString(d));
	}

}
