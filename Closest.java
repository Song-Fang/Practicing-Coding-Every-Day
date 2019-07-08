package com.algorimthms;

import java.util.Arrays;

public class Closest {
	public static void main(String[] args) {
		int [] array = {-1,2,1,-4};
		int target = 4;
		ClosestSolution cs = new ClosestSolution();
		System.out.println(cs.closestSolution(array, target));
	}
}

class ClosestSolution {
	public int closestSolution(int[] array, int target) {
		Arrays.sort(array);
		if (array == null || array.length < 2) {
			return -1;
		}

		int left = 0, right = array.length - 1;
		int closest = Integer.MAX_VALUE;
		while (left < right) {
			int minus = Math.abs(target - (array[left] + array[right]));
			closest = Math.min(closest, minus);
			if (array[left] + array[right] < target) {
				left++;
			} else if (array[left] + array[right] == target) {
				return 0;
			} else {
				right--;
			}
		}

		return closest;
	}
}