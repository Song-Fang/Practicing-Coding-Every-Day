package com.algorimthms;

import java.util.Arrays;

public class LessThanTarget {
	public static void main(String[] args) {
		int [] array = {2,7,11,15};
		int target = 24;
		LessThanTargetSolution ltts = new LessThanTargetSolution();
		System.out.println(ltts.lessThanTarget(array, target));
		
	}
}

class LessThanTargetSolution {
	public int lessThanTarget(int[] array, int target) {
		if (array == null || array.length < 2) {
			return 0;
		}
		int count = 0;
		Arrays.sort(array);
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] <= target) {
				count = count + right - left;
				left++;
			} else {
				right--;
			}
		}

		return count;
	}
}
