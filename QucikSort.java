package com.algorimthms;

public class QucikSort {
	public static void main(String[] args) {
		int [] array = {4,5,8,2,1,7};
		quickSort(array,0,array.length-1);
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
	}
	
	private static void quickSort(int [] array,int start,int end) {
		if(start>=end) {
			return;
		}
		
		int pivot = array[start+(end-start)/2];
		int left = start;
		int right = end;
		while(left<=right) {
			while(left<=right&&array[left]<pivot) {
				left++;
			}
			
			while(left<=right&&array[right]>pivot) {
				right--;
			}
			if(left<=right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
			
			quickSort(array,left,end);
			quickSort(array,start,right);
		}
		
	}

}
