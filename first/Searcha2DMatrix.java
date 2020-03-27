package com.example.first;

public class Searcha2DMatrix {
	/**
	 * Find a number in a 2D matrix.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return false;
        return binarySearchII(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
	
	/**
	 * Binary Search
	 * @param array
	 * @param target
	 * @return
	 */
	private boolean binarySearch(int [] array, int target){
		int begin = 0;
		int end = array.length - 1;
		while(begin <= end){
			int mid = (begin + end)/2;
			if(array[mid] == target)
				return true;
			if(array[mid] > target)
				end = mid - 1;
			if(array[mid] < target)
				begin = mid + 1;
		}
		return false;
	}
	
	/**
	 * Binary Search II
	 * @param array
	 * @param target
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private boolean binarySearchII(int [][] matrix, int target, int x1, int y1, int x2, int y2){
		if(x1 > x2 || y1 > y2)
			return false;
		int xx1 = x1;
		int xx2 = x2;
		int yy1 = y1;
		int yy2 = y2;
		while(xx1 <= xx2 && yy1 <= yy2){
			int mx = (xx1 + xx2) / 2;
			int my = (yy1 + yy2) / 2;
			if(matrix[mx][my] == target)
				return true;
			if(matrix[mx][my] > target){
				xx1 = mx - 1;
				yy1 = my - 1;
			}
			if(matrix[mx][my] < target){
				xx1 = mx + 1;
				yy1 = my + 1;
			}
		}
		return binarySearchII(matrix, target, xx1, y1, x2, yy2) || binarySearchII(matrix, target, x1, yy1, xx2, y2);
	}
}
