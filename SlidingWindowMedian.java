package com.algorimthms;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SlidingWindowMedian {
	public static void main(String [] args) {
		SlidingWindowMedianSolution ss = new SlidingWindowMedianSolution();
		int [] nums = {2147483647,1,2,3,4,5,6,7,2147483647};
		int k =2;
		ss.medianSlidingWindow(nums, k);
		
		
		
	}
}

class SlidingWindowMedianSolution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0||k>nums.length) return null;
        int n = nums.length;
        double [] result = new double[n-k+1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b, a));
        for(int i =0;i<nums.length;i++){
            if(maxHeap.isEmpty()||nums[i]<maxHeap.peek()){
                maxHeap.offer(nums[i]);
            }else{
                minHeap.offer(nums[i]);
            }
            
            balance(maxHeap,minHeap);
            if(i>=k-1){
                double mean = calculateMean(maxHeap,minHeap);
                result[i-k+1] = mean;
                remove(nums[i-k+1],maxHeap,minHeap);
            }
        }
        return result;
    }
    
    private void remove(int m,PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if(m>maxHeap.peek()){
            minHeap.remove(m);
        }else{
            maxHeap.remove(m);
        }
        
        //balance(maxHeap,minHeap);
    }
    
    private double calculateMean(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if(maxHeap.size()==minHeap.size()){
            return ((double)maxHeap.peek()+(double)minHeap.peek())*0.5;
        }else{
            return maxHeap.peek();
        }
    }
    
    private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        while(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
        while(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
    }
}
