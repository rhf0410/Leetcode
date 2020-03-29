package com.example.first;

import java.util.TreeSet;

public class longestconsecutivelength {
	/**
	 * Find the longest consecutive string length.
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        /*int [] dp = new int [nums.length + 1];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<nums.length;i++){
        	dp[i] = 1;
        	for(int j=0;j<i;j++){
        		if(nums[i] > nums[j]){
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	if(dp[i] > max)
        		max = dp[i];
        }
        return max;*/
        
        TreeSet<Integer>set = new TreeSet<Integer>();
        for(int num:nums){
        	Integer value = set.ceiling(num);
        	if(value != null)
        		set.remove(value);
        	set.add(num);
        }
        return set.size();
    }
}
