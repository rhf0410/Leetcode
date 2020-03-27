package com.example.first;

public class FindCoins {
	/**
	 * Find the minimal number of coins.
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int solution(int [] coins, int amount){
		if(coins == null || coins.length == 0 || amount == 0)
			return 0;
		int length = amount > coins[coins.length - 1] ? amount : coins[coins.length - 1];
		int [] dp = new int [length + 1];
		for(int i = 0;i<coins.length;i++){
			dp[coins[i]] = 1;
		}
		for(int i=1;i<=amount;i++){
			for(int j=0;j<i;j++){
				if(dp[i] == 0){
					dp[i] = dp[j] + dp[i-j];
				}else{
					dp[i] = Math.min(dp[j] + dp[i-j], dp[i]);
				}
			}
		}
		return dp[amount];
	}
}
