package com.algorimthms;

public class LongestSequence {
public static void main(String [] args) {
	int [] nums = {10,9,2,5,3,7,101,18};
	LongestSequenceSlution lss = new LongestSequenceSlution();
	System.out.println(lss.lengthOfLIS(nums));
}
}

class LongestSequenceSlution{
	public int lengthOfLIS(int [] nums) {
		int n = nums.length;
		int [] f = new int[n];
		for(int i =0;i<n;i++) {
			f[i] = 1;
		}
		
		for(int i =0;i<n;i++) {
			for(int j = 0;j<i;j++) {
				if(nums[j]<nums[i]) {
					f[i] = Math.max(f[i], f[j]+1);
				}
			}
		}
		
		int maxNum = 0;
		for(int i =0;i<n;i++) {
			maxNum = Math.max(maxNum, f[i]);
		}
		
		return maxNum;
	}
}
