package com.shankar.test;

public class Test1 {

	public static void main(String[] args) {
		int n=153;int b=n;
		int rem;int c;int sum=0;
	for(int a=155;n!=0;n=c) {
		c=n/10;
		rem=n%10;
		sum=(rem*rem*rem)+sum;
	
	}
	/*
	 * while(n!=0) { c=n/10; rem=n%10; sum=(rem*rem*rem)+sum; n=c;
	 * System.out.println(n+" "+sum+" "+rem); }
	 */	System.out.println(sum);
if(sum!=b) {
	System.out.println("not a armstrong number");
}
else {
	System.out.println(" armstrong number");
}
	}

}
