package com.algorimthms;

public class JumpGame {
	public static void main(String[] args) {
		JumpGameSolution jgs = new JumpGameSolution();
		int [] nums = {2,3,1,1,4};
		System.out.println(jgs.jumpGame(nums));

	}
}

class JumpGameSolution {
	public boolean jumpGame(int[] nums) {
		//avoid null pointer or indexOutOfBound exception
		if (nums == null || nums.length == 0) {
			return false;
		}

		boolean[] start = new boolean[nums.length];
		start[0] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (start[j] && i - j <= nums[j]) {
					start[i] = true;
				}
			}
		}
		return start[nums.length - 1];
	}
}
