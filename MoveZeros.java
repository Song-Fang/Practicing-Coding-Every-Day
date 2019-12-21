package com.algorimthms;

public class MoveZeros {
	public static void main(String[] args) {
		MoveZerosSolution1 mz = new MoveZerosSolution1();
		int [] nums = {0,2,1,0,5,3,0};
		mz.moveZero(nums);
		for(int num:nums) {
			System.out.println(num);
		}
	}
}

class MoveZerosSolution1 {
	public void moveZero(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for (; j < nums.length; j++) {
			nums[j] = 0;
		}
	}
}
