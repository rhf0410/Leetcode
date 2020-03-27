package com.example.first;

public class MaxRepeatedSubarray {
	/**
	 * Find the maximal length of both arrays.
	 * @param A
	 * @param B
	 * @return
	 */
	public int findLength(int[] A, int[] B) {
        if(A == null && B == null)
        	return 0;
        int [][] dp = new int [A.length + 1][B.length + 1];
        int max = 0;
        for(int i=1;i<=A.length;i++){
        	for(int j=1;j<=B.length;j++){
        		if(i-1 == 0 || j-1 == 0){
        			dp[i][j] = 0;
        		}
        		if(A[i-1] == B[j-1]){
        			dp[i][j] = dp[i-1][j-1] + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        /*int max = 0;
        int [] dp = new int [A.length + 1];
        for(int i=1;i<=B.length;i++){
        	for(int j=A.length;j>=1;j--){
        		if(A[j-1] == B[i-1]){
        			dp[j] = dp[j-1] + 1;
        		}else{
        			dp[j] = 0;
        		}
        		max = Math.max(max, dp[j]);
        	}
        }*/
        return max;
    }
}
