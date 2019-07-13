package com.algorimthms;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = { 3, 5, 9, 2, 7, 6 };
		bubbleSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

	private static void bubbleSort(int[] array) {
		for (int j = array.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}

}
