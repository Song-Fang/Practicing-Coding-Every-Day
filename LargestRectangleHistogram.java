package com.algorimthms;

import java.util.Stack;

public class LargestRectangleHistogram {

}

class LHSolution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int curt = stack.pop();
                if(stack.isEmpty()){
                    max = Math.max(max,heights[curt]*i);
                }else{
                    max = Math.max(max,heights[curt]*(i-stack.peek()-1));
                }  
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int right = heights.length;
            int curt = stack.pop();
            if(stack.isEmpty()){
                 max = Math.max(max,heights[curt]*right);
            }else{
                max = Math.max(max,heights[curt]*(right-stack.peek()-1));
            }
            

        }
        return max;
    }
}
