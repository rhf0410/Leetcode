package com.leetcode.one;

public class Leetcode714 {
	public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0)
        	return 0;
        int hold = Integer.MIN_VALUE/2;
        int sold = 0;
        for(int i=0;i<prices.length;i++){
        	int hold2 = hold;
        	int sold2 = sold;
        	int price = prices[i];
        	hold = Math.max(hold2, sold2 - price);
        	sold = Math.max(hold2 + price - fee, sold2);
        }
        return sold;
    }
}
