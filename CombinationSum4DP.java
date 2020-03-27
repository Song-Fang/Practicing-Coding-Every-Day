package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4DP {
	public static void main(String [] args) {
		CombinationSum4Solution css4 = new CombinationSum4Solution();
		int [] nums = {1,2,3};
		int  target = 32;
		System.out.println(css4.combinationSum(nums, target));
	}
}

/*
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
*/

//Dynamic Programming
class CombinationSum4Solution{
	public int combinationSum(int [] nums, int target) {
		if(nums==null||nums.length==0) return 0;
		int [] dp = new int[target+1];
		dp[0] = 1;
		for(int i =1;i<=target;i++) {
			dp[i] = 0;
			for(int j = 0;j<nums.length;j++) {
				if(nums[j]>i) continue;
				dp[i] = dp[i]+dp[i-nums[j]];
			}
		}
		
		return dp[target];
	}
}


