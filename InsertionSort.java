package com.algorimthms;

public class InsertionSort {
	public static void main(String[] args) {
		int [] array = {3,8,2,1,10,12};
		mergeSort(array);
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
	}
	
	public static void mergeSort(int [] array) {
		for(int i =1;i<array.length;i++) {
			for(int j = i;j>0&&array[j-1]>array[j];j--) {
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
			}
		}
	}
}
