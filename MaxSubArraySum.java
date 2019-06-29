package com.algorimthms;

public class MaxSubArraySum {
	public static void main(String[] args) {
		int [] array = {1,2,5,-4,8,-9,10};
		MaxSumSolution mss = new MaxSumSolution();
		System.out.println(mss.maxSubArraySum(array));
	}
}

class MaxSumSolution{
	public int maxSubArraySum(int [] array) {
		if(array==null||array.length==0) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0 ;
		int minSum = 0;
		for(int i =0;i<array.length;i++) {
			sum = array[i]+sum;
			max = Math.max(max, sum-minSum);
			minSum = Math.min(minSum, sum);
		}
		
		return max;
		
		
	}
}
