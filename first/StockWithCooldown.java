package com.example.first;

public class StockWithCooldown {
	/**
	 * Best time to sell and buy stock and cool down.
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
        	return 0;
        int rest = 0;
        int sold = 0;
        int hold = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
        	int pre_sold = sold;
        	sold = hold + prices[i];
        	hold = Math.max(hold, rest - prices[i]);
        	rest = Math.max(rest, pre_sold);
        }
        return Math.max(sold, rest);
    }
}
