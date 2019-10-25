package com.algorimthms;

public class PerfectSquare {
	public static void main(String [] args) {
		PerfectSquareSolution pss = new PerfectSquareSolution();
		System.out.println(pss.numSquare(12));
}
}

class PerfectSquareSolution{
	public int numSquare(int n) {
		int [] f = new int[n+1];
		for(int i =1;i<n+1;i++) {
			f[i] = Integer.MAX_VALUE;
		}
		
		for(int i =1;i*i<=n;i++) {
			f[i*i] = 1;
		}
		
		for(int i =1;i<=n;i++) {
			for(int j = 1;j*j<i;j++) {
				f[i] = Math.min(f[i],f[i-j*j]+1);
			}
		}
		
		return f[n];
	}
}
