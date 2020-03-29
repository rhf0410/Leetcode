package com.example.first;

public class MinimalPathSum {
	/**
	 * Find the minimal path sum
	 * @param grid:given grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
        	return 0;
        int minimal = 0;
        int n = grid.length;
        int m = grid[0].length;
        int [] dp = new int [n*m + 1];
        dp[0] = grid[0][0];
        for(int i=1;i<m;i++)
        	dp[i] = grid[0][i] + dp[i-1];
        for(int j=1;j<n;j++)
        	dp[j*m] = grid[j][0] + dp[(j-1)*m];
        for(int i=1;i<n;i++){
        	for(int j=1;j<m;j++){
        		dp[i*m+j] = Math.min(dp[i*m+j-1], dp[(i-1)*m+j]) + grid[i][j];
        	}
        }
        return dp[(n-1)*m + m - 1];
    }
}
