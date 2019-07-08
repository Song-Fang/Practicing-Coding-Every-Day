package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public static void main(String[] args) {
		int[] array = { 1, 0, -1, 0, -2, 2 };
		FourSumSolution fss = new FourSumSolution();

		ArrayList<ArrayList<Integer>> result = fss.fourSumSolution(array);
		System.out.println(result);
	}
}

class FourSumSolution {
	public ArrayList<ArrayList<Integer>> fourSumSolution(int[] array) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (array == null || array.length < 4) {
			return result;
		}

		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++) {
			if (i > 0 && array[i - 1] == array[i]) {
				i++;
			}

			for (int j = i + 1; j < array.length - 2; j++) {
				if (j > 0 && array[j - 1] == array[j]) {
					j++;
				}
				int left = j + 1, right = array.length - 1;
				int target = -(array[i] + array[j]);
				twoSum(array, result, target, left, right, i, j);
			}
		}
		return result;
	}

	private void twoSum(int[] array, ArrayList<ArrayList<Integer>> result, int target, int left, int right, int i,
			int j) {

		while (left < right) {
			if (array[left] + array[right] == target) {
				ArrayList<Integer> fourth = new ArrayList<Integer>();
				fourth.add(array[i]);
				fourth.add(array[j]);
				fourth.add(array[left]);
				fourth.add(array[right]);
				result.add(fourth);
				left++;
				right--;
				while (left < right && array[left] == array[left - 1]) {
					left++;
				}

				while (left < right && array[right] == array[right + 1]) {
					right--;
				}
			}

			if (array[left] + array[right] < target) {
				left++;
			}
			if (array[left] + array[right] > target) {
				right--;
			}
		}
	}
}
