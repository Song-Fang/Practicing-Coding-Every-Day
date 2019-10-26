package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivibleSubset {
	public static void main(String [] args) {
		int [] array = null;
		LDBSolution ls = new LDBSolution();
		System.out.println(ls.largestDivisibleSubset(array));

	}
}


class LDBSolution{
	    public List<Integer> largestDivisibleSubset(int[] nums) {
	    	
	    	List<Integer> list = new ArrayList<Integer>();
	        if(nums==null||nums.length==0){
	            return list;
	        }
	        
	        Arrays.sort(nums);
	        
	        int n = nums.length;
	        
	        int [] pre = new int[n];
	        
	        int [] f = new int[n];
	        
	        for(int i =0;i<n;i++){
	            f[i] = 1;
	        }
	        
	        for(int i =0;i<n;i++) {
	        	pre[i] = -1;
	        }
	        for(int i = 0;i<n;i++){
	            for(int j = 0;j<i;j++){
	                if(nums[i]%nums[j]==0){
	                    if(f[j]+1>f[i]) {
	                    	f[i] = f[j]+1;
	                    	pre[i] = j;
	                    }
	                }
	            }
	        }
	        int maxSum = Integer.MIN_VALUE;
	        int maxIndex = 0;
	        for(int i =0;i<n;i++){
	            if(f[i]>maxSum) {
	            	maxIndex = i;
	            	maxSum = f[i];
	            }
	        }
	        
	        while(maxIndex>=0) {
	        	list.add(nums[maxIndex]);
	        	maxIndex = pre[maxIndex];
	        }
	        
	        list.sort(null);
	        return list;
	        
	    }
}
