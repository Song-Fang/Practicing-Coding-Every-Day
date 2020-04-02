package com.algorimthms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {
	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7,8,9};
		int k =3;
		MaxSlidingWindowSolution ms = new MaxSlidingWindowSolution();
		int [] results = ms.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(results));
	}
}

class MaxSlidingWindowSolution {
	public int [] maxSlidingWindow(int [] nums,int k) {
		if(nums==null||nums.length==0||k>nums.length) {
			return new int[0];
		}
		
		int [] results = new int[nums.length-k+1];
		Deque<Integer> dp = new ArrayDeque<Integer>();
		
		for(int i =0;i<nums.length;i++) {
			if(!dp.isEmpty()&&dp.peekFirst()==i-k) {
				dp.pollFirst();
			}
			
			while(!dp.isEmpty()&&nums[i]>=nums[dp.peekLast()]) {
				dp.pollLast();
			}
			
			dp.offerLast(i);
			
			if(i>=k-1) {
				results[i-k+1] = nums[dp.peekFirst()];
			}
		}
		return results;
		
	}
}
