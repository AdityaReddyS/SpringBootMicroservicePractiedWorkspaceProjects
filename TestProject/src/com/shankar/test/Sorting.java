package com.shankar.test;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
System.out.println("Enter the no of elements");
int n=sc.nextInt();
System.out.println("Enter the the elements");
Integer[] a=new Integer[n];
for(int i=0;i<a.length;i++) {
	a[i]=new Integer(sc.nextInt());
}
Arrays.sort(a);
System.out.println("---sorted Array-----");
for(Integer k:a) {
	System.out.println(k+" ");
}
System.out.println("\n enter the elements to be searched");
Integer k=new Integer(sc.nextInt());
int z=Arrays.binarySearch(a, k);
if(k>=0) {
	System.out.println("Element found at the index="+z);
}
else {
	System.out.println("element is not available");
}
	}

}
