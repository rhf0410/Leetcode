package com.example.first;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class BestTimetoSABIV {
	/**
	 * Best time to sell and buy stock IV.
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
        	return 0;
        int result = 0;
        if(2 * k >= prices.length){
        	for(int i=1;i<prices.length;i++){
        		if(prices[i] - prices[i-1] > 0)
        			result += prices[i] - prices[i-1];
        	}
        	return result;
        }
        int [][] local = new int [prices.length + 1][k + 1];
        int [][] global = new int [prices.length + 1][k + 1];
        for(int i=1;i<prices.length;i++){
        	int diff = prices[i] - prices[i-1];
        	for(int j=1;j<=k;j++){
        		local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j] + diff);
        		global[i][j] = Math.max(global[i-1][j], local[i][j]);
        	}
        }
        return global[prices.length - 1][k];
    }
}
