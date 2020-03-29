package com.example.first;

public class ClimbingStairs {
	/**
	 * Climbing Stairs
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
        if(n == 0)
        	return 0;
        if(n <= 2)
        	return n;
        int [] dp = new int [n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<n+1;i++){
        	dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}
