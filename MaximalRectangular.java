package com.algorimthms;

import java.util.Stack;

public class MaximalRectangular {

}

class MaximalRectangularSolution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [] heights = new int[n];
        int max = 0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            max = Math.max(maxRectangle(heights),max);   
        }
        return max;
    }
    
    private int maxRectangle(int [] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for(int i =0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int cur = stack.pop();
                if(stack.isEmpty()){
                    max = Math.max(max,heights[cur]*i);
                }else{
                    max = Math.max(max,heights[cur]*(i-stack.peek()-1));
                }
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int right = heights.length;
            int cur = stack.pop();
            if(stack.isEmpty()){
                max = Math.max(max,heights[cur]*right);
            }else{
                max = Math.max(max,heights[cur]*(right-stack.peek()-1));
            }
        }
        
        return max;
    }
}
