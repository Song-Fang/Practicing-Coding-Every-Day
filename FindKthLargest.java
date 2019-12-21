package com.algorimthms;

import java.util.Arrays;
import java.util.PriorityQueue;


public class FindKthLargest {
	public static void main(String[] args) {

	}
}

class findKthLargestSolution1 {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int num : nums) {
			queue.offer(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}
}

class findKthElementSolution2{
	public int findLargestElement(int [] nums,int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
}

class findKthElementSolution3{
	public int findLargestElement(int [] nums,int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return nums[findLargestElement(nums,k,0,nums.length-1)];
	}
	
	private int findLargestElement(int [] nums,int k,int start,int end) {
		int pivot = partition(nums,start,end);
		int rank = end-pivot+1;
		if(rank ==k) {
			return pivot;
		}else if(rank<k) {
			return findLargestElement(nums,k-pivot,start,pivot-1);
		}else {
			return findLargestElement(nums,k,pivot+1,end);
		}
	}
	private int partition(int [] nums,int start,int end) {
		int pivot = nums[end];
		int left =0;
		for(int i =0;i<end;i++) {
			if(nums[i]<=pivot) {
				swap(nums,i,left++);
			}
		}
		swap(nums,left,end);
		return left;
	}
	
	private void swap(int []nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
}
