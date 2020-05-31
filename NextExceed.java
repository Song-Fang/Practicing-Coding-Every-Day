package com.algorimthms;

import java.util.Arrays;
import java.util.Stack;

//By using monotone stack
public class NextExceed {
	public static void main(String[] args) {
		int [] array = {5,3,1,2,4};
		NextExceedSolution ns = new NextExceedSolution();
		int [] result = ns.nextExceed(array);
		for(int i =0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}

class NextExceedSolution {
	public int [] nextExceed(int [] array) {
		int [] result = new int[array.length];
		Arrays.fill(result, -1);
		if(array==null||array.length==0) return result;
		Stack<Integer> stack = new Stack<>();
		
		for(int i =0;i<array.length;i++) {
			while(!stack.isEmpty()&&array[i]>array[stack.peek()]) {
				result[stack.peek()] = i-stack.peek();
				stack.pop();
			}
			stack.push(i);	
		}
		return result;
	}
}
