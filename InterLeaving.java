package com.algorimthms;

public class InterLeaving {
	public static void main(String[] args) {
		int [] array = {-1,7,8,-2,-4,6};
		InterLeavingSolution ils = new InterLeavingSolution();
		int [] result = ils.interLeaving(array);
		for(int i = 0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
	}
}

class InterLeavingSolution {
	public int[] interLeaving(int[] array) {
		if (array == null || array.length == 0 || array.length == 1) {
			return array;
		}

		int left = 0, right = array.length - 1;
		while (left < right) {
			while (left < right && array[left] < 0) {
				left++;
			}
			while (left < right && array[right] >= 0) {
				right--;
			}

			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}

		int i = 1, j = array.length - 2;
		while (i < j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i=i+2;
			j=j-2;
		}

		return array;
	}
}
