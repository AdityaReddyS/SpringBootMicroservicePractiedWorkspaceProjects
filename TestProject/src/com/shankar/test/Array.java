package com.shankar.test;

public  class Array {
	
	public static boolean arrayDiv(int[] a,int n) {
		int sum=0;
		//	System.out.println(arraySum(a, 3));
			for(int i=a.length-1;i>=0;i=i-2) {
				System.out.println(a[i]+","+a[i-1]);
				sum=a[i]+a[i-1];
				System.out.println(sum);
				
				if(sum % n !=0) {
				return false;
			}
				
			}
		return true;
	}
	
	public static boolean arraySum(int[] arr,int n) {
		int sum=0;
		
		for(int i=0;i<arr.length;i=i+2) {
			System.out.println(arr[i]+","+arr[i+1]);
			sum=arr[i]+arr[i+1];
			System.out.println("sum="+(arr[i]+arr[i+1]));
			if(sum % n !=0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int[] a= {3,6,9,12,15,6,6,9};
		System.out.println(arraySum(a, 3));
	}

}
