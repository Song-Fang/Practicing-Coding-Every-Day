package com.algorimthms;

public class ClimbStairs {
	public static void main(String[] args) {
		ClimbStairsSolution css = new ClimbStairsSolution();
		System.out.println(css.climbStairs(3));
	}
}

class ClimbStairsSolution {
	public int climbStairs(int m) {
		if (m == 0) {
			return 0;
		}
		if (m == 1) {
			return 1;
		}

		int[] stair = new int[m + 1];
		stair[0] = 1;
		stair[1] = 1;

		for (int i = 2; i <= m; i++) {
			stair[i] = stair[i - 1] + stair[i - 2];
		}

		return stair[m];
	}
}
