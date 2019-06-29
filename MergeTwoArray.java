package com.algorimthms;

public class MergeTwoArray {
	public static void main(String[] args) {
		int[] arrayOne = { 1, 2, 3, 4 };
		int[] arrayTwo = { 2, 4, 5, 6 };
		MergeSolution ms = new MergeSolution();
		int[] result = ms.mergeTwoArray(arrayOne, arrayTwo);

		if (result == null || result.length == 0) {
			System.out.println("null");
		} else {
			System.out.print("[");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+",");
			}
			System.out.println("]");
		}

	}
}

class MergeSolution {
	public int[] mergeTwoArray(int[] arrayOne, int[] arrayTwo) {
		if(arrayOne==null||arrayTwo==null) {
			return null;
		}
		
		int [] result = new int[arrayOne.length+arrayTwo.length];
		int i = 0, j =0,index = 0;
		while(i<arrayOne.length&&j<arrayTwo.length) {
			if(arrayOne[i]<arrayTwo[j]) {
				result[index++]= arrayOne[i++];
			}else {
				result[index++] = arrayTwo[j++];
			}
		}
		
		while(i<arrayOne.length) {
			result[index++] = arrayOne[i++];
		}
		
		while(j<arrayOne.length) {
			result[index++] = arrayTwo[j++];
		}
		
		return result;
	}
}
