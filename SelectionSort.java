package com.algorimthms;

public class SelectionSort {
	public static void main(String[] args) {
		int [] array = {3,5,9,2,7,6};
		selectionSort(array);
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
	}
	
	public static void selectionSort(int [] array) {
		for(int i =0;i<array.length-1;i++) {
			int min = i;
			for(int j=i+1;j<array.length;j++) {
				if(array[j]<array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
