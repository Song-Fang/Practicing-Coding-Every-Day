package com.algorimthms;

public class BubbleSortOptimized {
	public static void main(String[] args) {
		int[] array = { 3, 5, 9, 2, 7, 6 };
		bubbleSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

	private static void bubbleSort(int[] array) {
		int finalSwap = array.length - 1, swapPos;
		while (finalSwap > 0) {
			swapPos = 0;
			for (int i = 0; i < finalSwap; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					swapPos = i;
				}
			}
			finalSwap = swapPos;
		}
	}
}
