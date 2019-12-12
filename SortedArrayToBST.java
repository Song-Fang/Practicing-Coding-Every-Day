package com.algorimthms;

public class SortedArrayToBST {

}

class SortedArrayToBSTSolution {
	public Tree sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	private Tree sortedArrayToBST(int[] nums, int start, int end) {
		if(start>=end) {
			return null;
		}
		int mid = start + (end-start)/2;
		Tree root = new Tree(nums[mid]);
		root.left = sortedArrayToBST(nums, start,mid);
		root.right = sortedArrayToBST(nums,mid+1,end);
		return root;
	}
}
