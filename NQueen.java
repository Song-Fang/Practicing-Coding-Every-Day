package com.algorimthms;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public static void main(String[] args) {
		NQueenSolution ns = new NQueenSolution();
		List<List<String>> result = ns.solveNQueens(4);
		System.out.println(result);
	}
}

class NQueenSolution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		int[] nums = new int[n];
		findPosition(result, 0, n, nums);
		return result;

	}

	private void findPosition(List<List<String>> result, int i, int max, int[] nums) {
		if (i == max) {
			List<String> solution = new ArrayList<String>();
			for (int j = 0; j < max; j++) {
				StringBuilder sb = new StringBuilder();
				for (int p = 0; p < max; p++) {
					sb.append(p == nums[j] ? "Q" : ".");
				}
				solution.add(sb.toString());
			}
			result.add(solution);
			return;
		}

		for (int pos = 0; pos < max; pos++) {
			nums[i] = pos;
			if (check(nums, i)) {
				findPosition(result, i + 1, max, nums);
			}
		}

	}

	private boolean check(int[] nums, int n) {
		for (int i = 0; i < n; i++) {
			if (nums[i] == nums[n] || Math.abs(nums[i] - nums[n]) == Math.abs(i - n)) {
				return false;
			}
		}
		return true;
	}
}
