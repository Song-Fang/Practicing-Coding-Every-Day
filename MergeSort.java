package com.algorimthms;

public class MergeSort {
	public static void main(String[] args) {
		int [] array= {4,8,2,1,10,9,5};
		mergeSort(array,0,array.length-1);
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
		
	}
	
	private static void mergeSort(int [] array, int start, int end) {
		if(start>=end) {
			return;
		}
		int mid = start+(end-start)/2;
		mergeSort(array,start,mid);
		mergeSort(array,mid+1,end);
		merge(array,start,mid,end);
	}
	
	private static void merge(int [] array, int start,int mid,int end) {
		int [] temp = new int[end+1];
		int left = start;
		int right = mid+1;
		int index= 0;
		while(left<=mid&&right<=end) {
			if(array[left]<array[right]) {
				temp[index++] = array[left++];
			}
			else {
				temp[index++] = array[right++];
			}
		}
		
		while(left<=mid) {
			temp[index++] = array[left++];
		}
		
		while(right<=end) {
			temp[index++] = array[right++];
		}
		
		for(int i = start,j = 0;i<=end;i++,j++) {
			array[i] = temp[j];
		}
	}
}
