package com.example.first;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int max = nums[0];
        int cursum = nums[0];
        for(int i=1;i<nums.length;i++){
        	cursum = Math.max(nums[i], nums[i] + cursum);
        	max = Math.max(max, cursum);
        }
        return max;
    }
}
