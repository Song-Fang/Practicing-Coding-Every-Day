package com.algorimthms;

public class RemoveDuplicateElement {
	public static void main(String[] args) {
		int [] array = {1,1,2,2,4,4,5,6,7};
		RemoveDuplicateElementSolution rdes = new RemoveDuplicateElementSolution();
		System.out.println(rdes.removeDuplicateElement(array));
	}
}

class RemoveDuplicateElementSolution{
	public int removeDuplicateElement(int [] nums) {
		if(nums==null||nums.length==0) {
			return 0;
		}
		int pointer = 0;
		for(int i = 1;i<nums.length;i++) {
			if(nums[pointer]!=nums[i]) {
				pointer++;
				nums[pointer] = nums[i];
			}
		}
		return pointer+1;
	}
}
