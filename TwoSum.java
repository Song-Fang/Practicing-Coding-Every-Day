package com.algorimthms;

import java.util.HashMap;

public class TwoSum {

}

class TwoSumSolution{
	public int [] twoSum(int [] array,int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i =0;i<array.length;i++) {
			if(map.get(array[i])!=null) {
				int [] result = {map.get(array[i])+1,i+1};
				return result;
			}
			else {
				map.put(target-array[i], i);
			}
		}
		
		int [] result = {};
		return result;
	}
}
