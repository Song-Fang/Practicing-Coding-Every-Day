package com.algorimthms;

public class RemoveElement {
	public static void main(String[] args) {
		int [] array = {3,2,2,3};
		int target = 2;
		RemoveElementSolution res = new RemoveElementSolution();
		System.out.println(res.removeElement(array, target));
	}
}

class RemoveElementSolution {
	public int removeElement(int[] num, int target) {
		if (num == null || num.length == 0) {
			return 0;
		}

		int pointer = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != target) {
				num[pointer++] = num[i];
			}
		}
		return pointer;
	}
}
