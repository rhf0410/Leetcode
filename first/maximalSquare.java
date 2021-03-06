package com.example.first;

public class maximalSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int [n][m];
        int max = 0;
        for(int i=0;i<m;i++){
        	if(matrix[0][i] == '1'){
        		dp[0][i] = 1;
        		max = 1;
        	}
        }
        for(int i=0;i<n;i++){
        	if(matrix[i][0] == '1'){
        		dp[i][0] = 1;
        		max = 1;
        	}
        }
        for(int i=1;i<n;i++){
        	for(int j=1;j<m;j++){
        		if(matrix[i][j] == '1'){
        			dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
        			max = Math.max(dp[i][j], max);
        		}
        	}
        }
        return max * max;
    }
}
