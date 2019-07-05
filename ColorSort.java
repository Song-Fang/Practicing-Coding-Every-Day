package com.algorimthms;

public class ColorSort {
	public static void main(String[] args) {
		int [] array = {1,0,1,2};
		ColorSortSolution cs = new ColorSortSolution();
		int [] result = cs.colorSort(array);
		for(int i = 0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
	}
}

class ColorSortSolution {
	public int[] colorSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int left = 0, i = 0, right = array.length - 1;
		while (i <= right) {
			if (array[i] == 0) {
				int temp = array[i];
				array[i] = array[left];
				array[left] = temp;
				i++;
				left++;
			} else if (array[i] == 1) {
				i++;
			} else {
				int temp = array[i];
				array[i] = array[right];
				array[right] = temp;
				right--;
			}
		}

		return array;
	}
}
