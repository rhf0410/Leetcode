package com.example.first;

public class UglyNumberII {
	/**
	 * Ugly Numbers II
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        if(n == 0)
        	return 0;
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        for(int i=2;i<=n;i++){
        	dp[i] = Math.min(Math.min(dp[p1] * 2, dp[p2] * 3), dp[p3] * 5);
        	if(dp[i] == dp[p1]*2){
        		p1++;
        	}
        	if(dp[i] == dp[p2]*3){
        		p2++;
        	}
        	if(dp[i] == dp[p3]*5){
        		p3++;
        	}
        }
        return dp[n];
    }
}
