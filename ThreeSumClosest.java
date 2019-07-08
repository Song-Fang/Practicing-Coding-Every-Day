package com.algorimthms;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {
		int [] array = {-1,2,1,4};
		int target = 2;
		ThreeSumClosestSolution tscs = new ThreeSumClosestSolution();
		System.out.println(tscs.threeSumClosest(array, target));
	}
}

class ThreeSumClosestSolution {
	public int threeSumClosest(int[] array, int target) {
		if (array == null || array.length < 3) {
			return -1;
		}
		
		Arrays.sort(array);

		int bestSum = array[0] + array[1] + array[2];
		for (int i = 0; i < array.length - 2; i++) {
			int left = i + 1, right = array.length - 1;
			while (left < right) {
				int sum = array[i] + array[left] + array[right];
				int minus = Math.abs(target - sum);
				if (minus < Math.abs(target - bestSum)) {
					bestSum = array[i] + array[left] + array[right];
				}
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return bestSum;
	}
}
