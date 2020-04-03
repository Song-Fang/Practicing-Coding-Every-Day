package com.algorimthms;

public class SingleNumberII {
	public static void main(String[] args) {
		SingleNumberIISolution snii = new SingleNumberIISolution();
		int [] nums = {2,2,7,2,5,5,5};
		System.out.println(snii.findSingleNumber(nums));
	}
}

class SingleNumberIISolution {
	public int findSingleNumber(int[] nums) {
		if(nums==null||nums.length==0) return -1;
		int result = 0;
		for(int i =0;i<32;i++) {
			int sum = 0;
			for(int num:nums) {
				sum = sum+(num>>i&1);
			}
			sum = sum%3;
			result = result|(sum<<i);
		}
		return result;
	}
}
