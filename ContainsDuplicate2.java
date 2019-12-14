package com.algorimthms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate2 {

}


class ContainsDuplicate2Solution1{
	public boolean containsDuplicate(int k, int [] nums) {
		Map<Integer,Integer>  hashMap = new HashMap<Integer,Integer>();
		for(int i =0;i<nums.length;i++) {
			if(hashMap.containsKey(nums[i])) {
				if(i-hashMap.get(nums[i])<=k) {
					return true;
				}
			}
		}
		return false;
	}
}

class ContainsDuplicate2Solution2{
	public boolean containsDuplicate(int k, int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>(); 
		for(int i =0;i<nums.length;i++) {
			if(i>=k+1) {
				set.remove(i-k-1);
			}
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
