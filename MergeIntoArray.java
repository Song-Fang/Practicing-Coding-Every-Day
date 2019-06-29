package com.algorimthms;

public class MergeIntoArray {

}

class MergeIntoArraySolution{
	public void mergeIntoArray(int [] A, int m,int [] B,int n) {
		int i = m-1,j = n-1,index = m+n-1;
		while(i>=0&&j>=0) {
			if(A[i]<B[j]) {
				A[index--] = B[j--];
			}
			else {
				A[index--] = A[i--];
			}
		}
		
		while(j>=0) {
			A[index--] = B[j--];
		}
	}
}
