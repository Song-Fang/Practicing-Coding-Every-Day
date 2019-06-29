package com.algorimthms;

public class MedianTwoArray {
	public static void main(String[] args) {
		int [] A = {1,2,3,4,5};
		int [] B = {6};
		MedianSolution ms = new MedianSolution();
		System.out.println(ms.medianTwoArray(A, B));
	}
}

class MedianSolution {
	public double medianTwoArray(int[] A, int[] B) {
		if (A == null || B == null) {
			return 0;
		}
		int total = A.length + B.length;
		if (total % 2 == 0) {
			return (findKth(A, 0, B, 0, total / 2) + findKth(A, 0, B, 0, total / 2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, total / 2 + 1);
		}
	}

	private int findKth(int[] A, int indexA, int[] B, int indexB, int k) {
		if (indexA >= A.length) {
			return (indexB + k - 1);
		}

		if (indexB >= B.length) {
			return (indexA + k - 1);
		}

		if (k == 1) {
			return Math.min(A[indexA], B[indexB]);
		}

		int KeyA = Integer.MAX_VALUE;
		int KeyB = Integer.MAX_VALUE;

		if (indexA + k / 2 - 1 < A.length) {
			KeyA = A[indexA + k / 2 - 1];
		}
		if (indexB + k / 2 - 1 < B.length) {
			KeyB = B[indexB + k / 2 - 1];
		}

		if (KeyA < KeyB) {
			return findKth(A, indexA + k / 2, B, indexB, k - k / 2);
		} else {
			return findKth(A, indexA, B, indexB + k / 2, k - k / 2);
		}

	}
}
