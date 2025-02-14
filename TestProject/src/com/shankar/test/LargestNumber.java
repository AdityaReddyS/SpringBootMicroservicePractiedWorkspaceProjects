package com.shankar.test;

public class LargestNumber {
	
	public int findLargestNumber(int array[]) {
		int largest=array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i] >largest)
			
			largest=array[i];
		}
		return largest;
	}
	
	public int  findSmallestNumber(int array[]) {
		int smallest=array[0];
		for(int j=0;j<array.length;j++) {
			if(array[j] < smallest) {
				smallest=array[j];
			}
		}
		return smallest;
	}

	public static void main(String[] args) {
	int array[]= {98,201,45,32,49,286,999};
	LargestNumber ln=new LargestNumber();
	int largest=ln.findLargestNumber(array);
System.out.println("largest Number::"+largest);

int smallest=ln.findSmallestNumber(array);
System.out.println("smallest number::"+smallest);
	}

}
