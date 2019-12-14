package com.algorimthms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

}

class ContainsDuplicateSolution1{
	public boolean containsDuplicate(int [] nums) {
		Set<Integer> mySet = new HashSet<Integer>();
		for(int num:nums) {
			if(mySet.contains(num)) {
				return true;
			}else {
				mySet.add(num);
			}
		}
		return false;
	}
}

class ContainsDuplicateSolution2{
	public boolean containsDuplicate(int [] nums) {
		Arrays.sort(nums);
		for(int i =0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1]) {
				return true;
			}
		}
		return false;
	}
}
