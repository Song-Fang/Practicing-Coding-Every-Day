package com.algorimthms;

public class Fabonacci {
public static void main(String [] args) {
	FabonacciSolution fs = new FabonacciSolution();
	System.out.println(fs.fabonacci(10));
}
}

class FabonacciSolution{
	public int fabonacci(int N) {
		int [] nums = new int[N+1];
		if(N==0) {
			return 0;
		}
		if(N==1) {
			return 1;
		}
		nums[0] =0;
		nums[1] =1;
		for(int i =2;i<N+1;i++) {
			nums[i] = nums[i-1]+nums[i-2];
		}
		
		return nums[N];
	}
}


