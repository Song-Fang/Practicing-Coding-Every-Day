package com.algorimthms;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumberIII {
	public static void main(String[] args) {
		int [] nums = {1,2,1,3,2,5};
		SingleNumberIIISolution ss = new SingleNumberIIISolution();
		int [] result = ss.singleNumber(nums);
		System.out.println(Arrays.toString(result));
		
	}
}

class SingleNumberIIISolution {
	public int[] singleNumber(int[] nums) {

		if (nums == null || nums.length == 0)
			return new int[0];
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		int i = 0;
		for (Integer ele : map.keySet()) {
			if (map.get(ele) == 1) {
				result[i++] = ele;
			}
		}
		return result;
	}
}
