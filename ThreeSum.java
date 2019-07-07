package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public static void main(String[] args) {
		int [] array = {1,-2,5,-1,3,-1,-2,2};
		ThreeSumSolution ts = new ThreeSumSolution();
		System.out.println(ts.threeSum(array));
	}
}

class ThreeSumSolution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] array) {
		Arrays.sort(array);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (array == null || array.length < 3) {
			return result;
		}
		for (int i = 0; i < array.length - 2; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			int target = -array[i];
			int left = i + 1;
			int right = array.length - 1;
			twoSum(array, result, target, left, right);
		}
		return result;
	}

	private ArrayList<ArrayList<Integer>> twoSum(int[] array, ArrayList<ArrayList<Integer>> result, int target,
			int left, int right) {
		ArrayList<Integer> subResult = new ArrayList<Integer>();
		while (left < right) {
			if (array[left] + array[right] == target) {
				subResult.add(-target);
				subResult.add(array[left]);
				subResult.add(array[right]);
				result.add(subResult);
				left++;
				right--;
				while (left < right && array[left] == array[left - 1]) {
					left++;
				}
				while (left < right && array[right] == array[right + 1]) {
					right--;
				}
			}

			else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}
