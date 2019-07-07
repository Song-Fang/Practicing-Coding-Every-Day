package com.algorimthms;

public class TwoSum2 {
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8};
		int target = 9;
		TwoSum2Solution tss = new TwoSum2Solution();
		int [] result = tss.twoSum2(array, target);
		System.out.print("[");
		for(int i =0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
		System.out.println("]");
		
	}
}

class TwoSum2Solution {
	public int[] twoSum2(int[] array, int target) {
		int left = 0, right = array.length - 1;
		int[] result = new int[2];
		if (array == null || array.length == 0) {
			return result;
		}
		while (left < right) {
			if (array[left] + array[right] == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				return result; 
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}
