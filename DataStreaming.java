package com.algorimthms;

import java.util.PriorityQueue;

public class DataStreaming {

}

class MedianFinder {
    
    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        
        
        
        if(maxHeap.isEmpty()||num<maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        
        if(maxHeap.size()==minHeap.size()+2){
            minHeap.offer(maxHeap.poll());
        }
        
        if(maxHeap.size()+1==minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}
