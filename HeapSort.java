package com.algorimthms;

public class HeapSort {
	public static void main(String[] args) {
		int [] arr = {5,8,10,22,6,9};
		int n = arr.length;
		heapSort(arr,n);
		for(int num: arr) {
			System.out.println(num);
		}
		
	}
	
	private static void buildHeap(int [] array,int n) {
		if(array==null||array.length==0) return;
		int start = (n-2)/2;
		for(int i =start;i>=0;i--) {
			heapify(array,n,i);
		}
	}
	
	private static void heapSort(int [] array,int n) {
		buildHeap(array,n);
		for(int i = n-1;i>=0;i--) {
			swap(array,i,0);
			heapify(array,i,0);
		}
	}
	
	private static void heapify(int [] array,int n,int i) {
		if(array==null||array.length==0) return;
		if(i>=n) return;
		int max = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left<n&&array[left]>array[max]) {
			max = left;
		}
		if(right<n&&array[right]>array[max]) {
			max = right;
		}
		
		if(max!=i) {
			swap(array,max,i);
			heapify(array,n,max);
		}
			
	}
	
	private static void swap(int [] array,int a,int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}


