package com.shankar.test;

public class Testdsdfg {

	public static boolean arrayDiv(int[] a,int n) {
		int sum=0;
		for(int i=0,j=a.length-1;i<a.length / 2 ;i++,j--) {
			System.out.println(a[i]+" "+a[j]);
			sum=a[i]+a[j];
			if(sum % n!=0) {
				System.out.println("sum="+sum);
				System.out.println("number is not divisible by giveen number::"+n);
			return false;
			}
			
		
		}	
	
return true;
	}
	public static void main(String[] args) {
		int[] a= {12,6,8,4,7,9,5,6};
		System.out.println(arrayDiv(a, 6));
		
		
	}
}

