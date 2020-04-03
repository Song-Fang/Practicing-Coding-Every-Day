package com.algorimthms;

//By using BitMap
public class SingleNumberI {
	public static void main(String[] args) {
		int [] nums = {2,2,1,4,4};
		SingleNumberISolution snis = new SingleNumberISolution();
		System.out.println(snis.singleNumberSearch(nums));
	}
}

class SingleNumberISolution {
	public int singleNumberSearch(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int result = 0;
		for (int num : nums) {
			result = num ^ result;
		}
		return result;
	}
}