package com.shankar.test;

public class SecondLargestNumber {
	
	public int secondLargestNumber(int array[]) {
		int largest=0;
		int seclargest=0;
		for(int i=0;i<array.length;i++) {
			if(array[i] > largest) {
				seclargest=largest;
				largest=array[i];
			}
			else if(array[i] < largest && array[i]>=seclargest) {
				seclargest=array[i];
			}
		}
		return seclargest;
	}

	public int secondSmallestNuber(int array[]) {
		int smallest=array[0];
		int secondsmallest=array[1];
		for(int i=0;i<array.length;i++) {
			if(array[i] < smallest) {
				secondsmallest=smallest;
				smallest=array[i];
			}
			else if(array[i] > smallest && array[i] <= secondsmallest) {
				secondsmallest=array[i];
			}
		}
		return secondsmallest;
	}
	public static void main(String[] args) {
		int[] array=new int[] {185,105,25,653,235,456,235};
		SecondLargestNumber sn=new SecondLargestNumber();
		
		
int secondlargest=sn.secondLargestNumber(array);
System.out.println("second largest number ::"+secondlargest);

int secondsmallest=sn.secondSmallestNuber(array);
System.out.println("second smallest number ::"+secondsmallest);
	}

}
