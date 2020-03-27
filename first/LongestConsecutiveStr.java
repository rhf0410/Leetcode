package com.example.first;

import java.util.Arrays;

public class LongestConsecutiveStr {
	/**
	 * Find the longest consecutive string.
	 * @param nums
	 * @return
	 */
	public int findLengthOfLCIS(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int max = 1;
        int [] dp = new int [nums.length  + 1];
        Arrays.fill(dp, 1);
        for(int i=1;i<nums.length;i++){
        	if(nums[i] > nums[i-1]){
        		dp[i] = Math.max(dp[i], dp[i-1] + 1);
        		max = dp[i] > max ? dp[i] : max;
        	}
        }
        return max;
    }
}
