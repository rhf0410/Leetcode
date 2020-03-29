package com.example.first;

public class MissingNumber {
	/**
	 * Missing Number.
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int result = 0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
        	result ^= nums[i];
        }
        for(int i=0;i<=n;i++){
        	result ^= i;
        }
        return result;
    }
}
