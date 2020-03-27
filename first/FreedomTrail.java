package com.example.first;

public class FreedomTrail {
	/**
	 * 
	 * @param ring
	 * @param key
	 * @return
	 */
	public int findRotateSteps(String ring, String key) {
        if(ring == null || ring.length() == 0 || key == null || key.length() == 0)
        	return 0;
        if(ring.length() < 1 || ring.length() > 100 || key.length() < 1 || key.length() > 100)
        	return 0;
        int n = ring.length();
        int m = key.length();
        int [][] dp = new int[m+1][n];
        for(int i=m-1;i>=0;i--){
        	for(int j=0;j<n;j++){
        		dp[i][j] = Integer.MAX_VALUE;
        		for(int k=0;k<n;k++){
        			if(ring.charAt(k) == key.charAt(i)){
        				int diff = Math.abs(j-k);
        				int step = Math.min(diff, n-diff);
        				dp[i][j] = Math.min(dp[i][j], step + dp[i+1][k]);
        			}
        		}
        	}
        }
        return dp[0][0] + m;
    }
}
