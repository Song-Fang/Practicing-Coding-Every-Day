package com.algorimthms;

public class Beat {
	public static void main(String [] args) {
		BeatSolution bs = new BeatSolution();
		int [] num = {24,88,102,2,5,7};
		System.out.println(bs.maxValue(num));
	}
}

class BeatSolution{
	public int maxValue(int [] array) {
		int sum = Integer.MIN_VALUE;
		for(int i =0;i<array.length;i++) {
			sum = Math.max(sum, array[i]);
		}
		return sum;
	}
}
