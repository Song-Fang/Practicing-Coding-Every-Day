package com.algorimthms;

public class MaximumCircularSubArray {

}

//brute force
//method of sliding window
//exceeding time limit
class MCSSolution1 {
  public int maxSubarraySumCircular(int[] A) {
      if(A==null||A.length==0) return 0;
      int max = Integer.MIN_VALUE;
      for(int i =0;i<A.length;i++){
              max = Math.max(max,maxSubarray(A,i));
      }
      
      return max;
  }
  
  private int maxSubarray(int [] A, int i){
      int  max = A[i];
      int tillMax = A[i];
      for(int j = i+1;j<i+A.length;j++){
          tillMax = tillMax+A[j%A.length];
          tillMax = Math.max(tillMax,A[j%A.length]);
          max = Math.max(max,tillMax);
      }
      return max;
  }
}

//use total sum
class MCSSolution2 {
    public int maxSubarraySumCircular(int[] A) {
        if(A==null||A.length==0) return -1;
        int max = A[0];
        int tillMax = A[0];
        int tillMin = A[0];
        int min = A[0];
        int total = A[0];
        for(int i =1;i<A.length;i++){
            total = total+A[i];
            tillMax = tillMax+A[i];
            tillMax = Math.max(tillMax,A[i]);
            max = Math.max(max,tillMax);
            
            tillMin = tillMin+A[i];
            tillMin = Math.min(tillMin,A[i]);
            min = Math.min(min,tillMin);
            
        }
        
        if(total==min){
            return max;
        }
        
        return Math.max(total-min,max);
        
    }
}
