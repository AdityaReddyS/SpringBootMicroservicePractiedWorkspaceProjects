package com.shankar.test;

import java.util.Scanner;

public class PrimeNumber {

	public static boolean isPrime(int p) {
		for(int k=1;k<p;k++) {
		for(int i=2;i<k;i++) {
			
			if(p%i ==0) {
				System.out.println("not a prime number"+k);
				
		break;
			}
			else {
				System.out.println("prime number");
				
			}
		}
		
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int n=sc.nextInt();
		System.out.println(isPrime(n));
			}
	

}
