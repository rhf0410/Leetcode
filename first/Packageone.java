package com.example.first;

public class Packageone {
	public int backPack(int m, int[] A) {
		if(A == null || A.length == 0 || m == 0)
			return 0;
		int [] dp = new int [m+1];
		dp[0] = 0;
		for(int i=0;i<A.length;i++){
			for(int j=m;j>0;j--){
				if(j >= A[i]){
					dp[j] = Math.max(dp[j], dp[j-A[i]] + A[i]);
				}
			}
		}
        return dp[m];
    }
	
	public int backPackII(int m, int[] A, int V[]){
		int [] dp = new int [m+1];
		for(int i=0;i<A.length;i++){
			for(int j=m;j>0;j--){
				if(j > A[i]){
					dp[j] = Math.max(dp[j], dp[j-A[i]] + V[i]);
				}
			}
		}
		return dp[m];
	}
}
