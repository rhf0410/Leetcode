package com.example.first;

public class UniquePathsII {
	/**
	 * Find unique paths ignoring obstacles
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
        	return 0;
        if(obstacleGrid[0][0] == 1)
        	return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int [] dp = new int [n*m+1];
        for(int i=0;i<m;i++){
        	if(obstacleGrid[0][i] == 0){
        		dp[i] = 1;
        	}else{
        		break;
        	}
        }
        for(int j=1;j<n;j++){
        	if(obstacleGrid[j][0] == 0){
        		dp[j*m] = 1;
        	}else{
        		break;
        	}
        }
        for(int i=1;i<n;i++){
        	for(int j=1;j<m;j++){
        		if(obstacleGrid[i][j] == 1)
        			continue;
        		else
        			dp[i*m+j] = dp[(i-1)*m+j] + dp[i*m + j-1];
        	}
        }
        return dp[(n-1)*m + (m-1)];
    }
}
