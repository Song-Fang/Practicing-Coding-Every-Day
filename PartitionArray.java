package com.algorimthms;

public class PartitionArray {
	public static void main(String[] args) {
		int k = 2;
		int [] array = {3,2,2,1};
		PartitionSolution ps = new PartitionSolution();
		System.out.println(ps.partitionArray(array, k));
	}
}

class PartitionSolution {
	public int partitionArray(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int left = 0, right = array.length - 1;
		while (left < right) {
			while (left < right && array[left] < k) {
				left++;
			}

			while (left < right && array[right] >= k) {
				right--;
			}

			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		if (array[left] < k) {
			return left + 1;
		} else {
			return left;
		}
	}
}
