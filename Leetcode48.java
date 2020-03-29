package com.leetcode.one;

public class Leetcode48 {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
        	return;
        }
        
        int length = matrix.length;
        int width = matrix[0].length;
        
        for(int i=0;i<=length/2;i++){
        	int temp = 0;
        	int n = width-1;
        	for(int j=i;j<n-i;j++){
        		temp = matrix[j][n-i];
        		matrix[j][n-i] = matrix[i][j];
        		matrix[i][j] = matrix[n-j][i];
        		matrix[n-j][i] = matrix[n-i][n-j];
        		matrix[n-i][n-j] = temp;
        	}
        }
    }
}
