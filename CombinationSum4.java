package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {
	public static void main(String [] args) {
		CombinationSumSolution4 css4 = new CombinationSumSolution4();
		int [] nums = {1,2,3};
		int  target = 32;
		System.out.println(css4.combinationSum(nums, target));
	}
}

class CombinationSumSolution4{
	int count;
	public int combinationSum(int [] nums, int target) {
		count = 0;
		if(nums==null||nums.length==0) return count;
		Arrays.sort(nums);
		helper(nums,target,new ArrayList<Integer>());
		return count;
	}
	
	private void helper(int [] nums, int target, List<Integer> list) {
		if(target==0) {
			count++;
			return;
		}
		for(int i =0;i<nums.length;i++) {
			if(nums[i]>target) break;
			list.add(nums[i]);
			helper(nums,target-nums[i],list);
			list.remove(list.size()-1);
		}
	}
}


