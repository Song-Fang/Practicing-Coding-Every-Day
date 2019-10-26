package com.algorimthms;

public class PrintArray {
public static void main(String [] args) {
	int [] nums  = new int[100];
	for(int i =0;i<100;i++) {
		nums[i] =i;
	}
	
	int count =0;
	for(int i=0;i<100;i++) {
		System.out.print(nums[i]+"	");
		count++;
		if(count%10==0) {
			System.out.println();
		}
	}
}
}
