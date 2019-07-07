package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ThreeSum2 {
	public static void main(String[] args) {
		int [] array = {1,-2,5,-1,3,-1,-2,2};
		ThreeSumSolution ts = new ThreeSumSolution();
		System.out.println(ts.threeSum(array));
	}
}

/*
class ThreeSumSolution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] array) {
		Arrays.sort(array);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (array == null || array.length < 3) {
			return result;
		}
		for (int i = 0; i < array.length - 2; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			int target = -array[i];
			int left = i + 1;
			int right = array.length - 1;
			twoSum(array, result, target, left, right);
		}
		return result;
	}

	private void twoSum(int[] array, ArrayList<ArrayList<Integer>> result, int target,
			int left, int right) {
		
		while (left < right) {
			
			if (array[left] + array[right] == target) {
				ArrayList<Integer> subResult = new ArrayList<Integer>();
				subResult.add(-target);
				subResult.add(array[left]);
				subResult.add(array[right]);
				result.add(subResult);
				left++;
				right--;
				while (left < right && array[left] == array[left - 1]) {
					left++;
				}
				while (left < right && array[right] == array[right + 1]) {
					right--;
				}
			}

			else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}
}
*/

class ThreeSumSolution{
	public HashSet<ArrayList<Integer>> threeSum(int [] array){
		Arrays.sort(array);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		if(array==null||array.length<3) {
			return set;
		}
		
		for(int i =0;i<array.length-2;i++) {
			if(i>0&&array[i]==array[i-1]) {
				continue;
			}
			int target = -array[i];
			int start = i+1;
			twoSum(set,array,target,start);
		}
		
		return set;	
	}
	
	private void twoSum(HashSet<ArrayList<Integer>> set, int [] array, int target, int start) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = start;i<array.length;i++) {
			if(map.get(array[i])!=null) {
				ArrayList<Integer> triple = new ArrayList<Integer>();
				triple.add(-target);
				triple.add(array[map.get(array[i])]);
				triple.add(array[i]);
				set.add(triple);
			}
			else {
				map.put(target-array[i], i);
			}
		}
	}
	
	
}
