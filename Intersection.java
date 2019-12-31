package com.algorimthms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
	public static void main(String[] args) {
		IntersectionSolution ist = new IntersectionSolution();
		int [] nums1 = {1,2,2,1};
		int [] nums2 = {2,2};
		int [] result = ist.intersect(nums1, nums2);
		
		for(int item:result) {
			System.out.println(item);
		}
		
	}
}

class IntersectionSolution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < nums2.length; i++) {
			if (map.getOrDefault(nums2[i], 0) > 0) {
				result.add(nums2[i]);
				map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
			}
		}

		int[] arr = new int[result.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = result.get(i);
		}

		return arr;
	}
}
