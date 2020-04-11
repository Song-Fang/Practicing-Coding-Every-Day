package com.algorimthms;

import java.util.HashMap;
import java.util.Map;

public class SetMissMatch {

}

class SetMissMatchSolution{
	//brute force
	
	/*
	public int [] setMissmatch(int [] nums) {
		if(nums==null||nums.length==0) return new int[]{-1,-1};
        int dup = -1;
        int miss = -1;
        for(int i =1;i<=nums.length;i++){
            int count = 0;
            for(int j =0;j<nums.length;j++){
                if(nums[j]==i){
                    count++;
                }
            }
            if(count==2){
                dup = i;
            }
            if(count==0){
                miss = i;
            }
            if(dup!=-1&&miss!=-1){
                break;
            }
        }
        
        return new int[]{dup,miss};
	}
	*/
	
	//using HashMap
	/*
	public int[] findErrorNums(int[] nums) {
        int dup = -1, miss = -1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i =1;i<=nums.length;i++){
            if(map.containsKey(i)){
                if(map.get(i)==2) dup = i;
            }else{
                miss = i;
            }
        }
        return new int[]{dup,miss};
    }
    */
	 //Using Array
	/*
    public int[] findErrorNums(int[] nums) {
        int [] record = new int[nums.length+1];
        int dup = -1, miss = -1;
        for(int i =0;i<nums.length;i++){
            record[nums[i]]+=1;
        }
        
        for(int i =1;i<record.length;i++){
            if(record[i]==0){
                miss = i;
            }
            if(record[i]==2){
                dup = i;
            }
        }
        return new int[]{dup,miss};
        
    }
    */
	
	//Using Sorting
	/*
    public int[] findErrorNums(int[] nums) {
       Arrays.sort(nums);
        int dup = -1, miss = 1;
       for(int i =1;i<nums.length;i++){
           if(nums[i]==nums[i-1]){
               dup = nums[i];
           }else if(nums[i]-1!=nums[i-1]){
               miss = nums[i]-1;
           }
       }
        if(nums[nums.length-1]!=nums.length) miss = nums.length;
        return new int[]{dup,miss};
    }
    */
	  //O(n) O(1) space
	  //Don't ignore the Math.abs()
    public int[] findErrorNums(int[] nums) {
       int dup =-1, miss = -1;
        for(int i =0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                dup = Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                miss = i+1;
            }
        }
        
        return new int[]{dup,miss};
    }
	
}
