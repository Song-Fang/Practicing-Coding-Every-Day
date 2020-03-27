package com.algorimthms;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public static void main(String[] args) {
		CombinationSum3Solution css3 = new CombinationSum3Solution();
		int k = 3;
		int n = 7;
		System.out.println(css3.combinationSum(k, n));
	}
}

class CombinationSum3Solution {
	public List<List<Integer>> combinationSum(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (k <= 0 || k > 9)
			return result;
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = 0;
		helper(result, new ArrayList<Integer>(), nums, k, n, index);
		return result;

	}

	private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int k, int n, int index) {
		if (n == 0 && list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		if (list.size() == k)
			return;

		for (int i = index; i < nums.length; i++) {
			if (nums[i] > n)
				break;
			list.add(nums[i]);
			helper(result, list, nums, k, n - nums[i], i + 1);
			list.remove(list.size() - 1);
		}
	}
}
