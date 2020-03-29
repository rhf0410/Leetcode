package com.example.first;

public class UniquePaths {
	/**
	 * Find unique paths
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0)
        	return 0;
        if(m > 100 || n > 100)
        	return 0;
        int dp[] = new int[m*n+1];
        dp[0] = 1;
        for(int i=1;i<n;i++){
        	dp[i] = 1; 
        }
        for(int i = 1;i<m;i++){
        	dp[i*n] = 1;
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		dp[(i*n) + j] = dp[(i*n) + j-1] + dp[(i-1)*n+j];
        	}
        }
        return dp[(m-1)*n + (n-1)];
    }
}
