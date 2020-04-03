package com.algorimthms;

public class SearchMatrix2D {
	public static void main(String[] args) {
		int [][] matrix = {{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		int target = 60;
		SearchMatrix2DSolution sm2 = new SearchMatrix2DSolution();
		System.out.println(sm2.searchMatrix(matrix, target));
	}
	
}

class SearchMatrix2DSolution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
		int maxRow = matrix.length-1;
		int maxCol = matrix[0].length-1;
		int curtRow = 0;
		int curtCol = maxCol;
		while(curtRow<=maxRow&&curtCol>=0) {
			if(matrix[curtRow][curtCol]==target) {
				return true;
			}else if(matrix[curtRow][curtCol]>target) {
				curtCol--;
			}else {
				curtRow++;
			}
		}
		
		return false;
	}
}
