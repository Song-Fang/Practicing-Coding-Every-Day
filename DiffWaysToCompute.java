package com.algorimthms;

import java.util.ArrayList;
import java.util.List;

//Test
public class DiffWaysToCompute {
	public static void main(String[] args) {
		String input ="1+5*9-10";
		DiffWaysToComputeSolution dwtc = new DiffWaysToComputeSolution();
		System.out.println(dwtc.diffWaysToCompute(input));
	}
}

class DiffWaysToComputeSolution {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		if(input ==null||input.length()==0) return result;
		
		for(int i =0;i<input.length();i++) {
			char c = input.charAt(i);
			if("+-*".indexOf(c)>=0) {
				List<Integer> left = diffWaysToCompute(input.substring(0,i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1));
				
				for(Integer m: left) {
					for(Integer n:right) {
						switch(c) {
						case '+':result.add(m+n);break;
						case '-':result.add(m-n);break;
						case '*':result.add(m*n);break;
						}
					}
				}
			}
		}
		
		if(result.isEmpty()) {
			result.add(Integer.parseInt(input));
		}
		
		return result;
		
	}
}
