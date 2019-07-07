package com.algorimthms;

public class UniquePairs {
	public static void main(String[] args) {
		int [] array = {1,1,2,2,3,4,5,6,7,8};
		int target = 9;
		UniquePairsSolution ups = new UniquePairsSolution();
		System.out.println(ups.uniquePairs(array, target));
		
	}
}

class UniquePairsSolution {
	public int uniquePairs(int[] array, int target) {
		int left = 0, right = array.length - 1;
		int count = 0;
		while (left < right) {
			if (array[left] + array[right] == target) {
				count++;
				left++;
				right--;
				while(left<right&&array[left]==array[left-1]) {
					left++;
				}
				
				while(left<right&&array[right]==array[right-1]) {
					right--;
				}
			}

			if (array[left] + array[right] < target) {
				left++;
			}
			if (array[left] + array[right] > target) {
				right--;
			}
		}
		return count;
	}
}
