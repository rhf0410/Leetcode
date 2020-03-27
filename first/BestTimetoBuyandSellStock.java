package com.example.first;

public class BestTimetoBuyandSellStock {
	/**
	 * Find the maximum profit
	 * @param prices:prices of things
	 * @return
	 */
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
        	return 0;
        if(prices.length == 2){
        	return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        }
        int n = prices.length;
        int max = prices[n-1] - prices[n-2];
        int maxprice = prices[n-1];
        for(int i=n-2;i>=0;i--){
        	if(max<maxprice - prices[i])
        		max = maxprice - prices[i];
        	if(maxprice < prices[i])
        		maxprice = prices[i];
        }
        return max > 0 ? max : 0;
    }
}
