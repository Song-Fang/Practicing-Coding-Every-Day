package com.algorimthms;

public class MoveZeros2 {
	public static void main(String[] args) {
		MoveZerosSolution2 mz = new MoveZerosSolution2();
		int [] nums = {0,0,2,0,1,0,5,0,3,0,0,0,0};
		mz.moveZero(nums);
		for(int num:nums) {
			System.out.println(num);
		}
	}
}

class MoveZerosSolution1 {
	public void moveZero(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for (; j < nums.length; j++) {
			nums[j] = 0;
		}
	}
}


class MoveZerosSolution2{
	public void moveZero(int [] nums) {
		if(nums.length==0||nums==null) {
			return;
		}
		
		int left = 0;
		int right = nums.length-1;
		while(left<right) {
			while(left<right&&nums[left]!=0) {
				left++;
			}
			while(left<right&&nums[right]==0) {
				right--;
			}
			
			if(left<right) {
				swap(nums,left,right);
				left++;
				right--;
			}
			
		}
		
	}
	
	private void swap(int [] nums, int left,int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
