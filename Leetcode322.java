package com.example.second;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode322 {
	/**
	 * Coin exchange.
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
        int result = -1;
        if(coins == null || coins.length == 0)
        	return result;
        int [] dp = new int [amount + 1];
        for(int i=1;i<dp.length;i++){
        	dp[i] = i + 1;
        	for(int j=0;j<coins.length;j++){
        		if(i>=coins[j] && dp[i-coins[j]] != -1){
        			dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
        		}
        	}
        	if(dp[i] == i+1){
        		dp[i] = -1;
        	}
        }
        return dp[amount];
    }
	
	public int coinChange2(int[] coins, int amount){
		if(coins == null || coins.length == 0)
        	return -1;
		if(amount == 0)
			return 0;
		Queue<Integer>queue = new LinkedList<Integer>();
		boolean [] visited = new boolean [amount + 1];
		queue.add(0);
		visited[0] = true;
		int number = 0;
		while(!queue.isEmpty()){
			number++;
			Queue<Integer>queue2 = new LinkedList<Integer>();
			while(!queue.isEmpty()){
				int value = queue.remove();
				for(int i=0;i<coins.length;i++){
					int newvalue = value + coins[i];
					if(newvalue == amount)
						return number;
					if(newvalue > amount)
						continue;
					if(!visited[newvalue]){
						visited[newvalue] = true;
						queue2.add(newvalue);
					}
				}
			}
			queue.clear();
			queue.addAll(queue2);
			queue2.clear();
		}
		return -1;
	}
}
