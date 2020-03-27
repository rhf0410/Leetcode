package com.leetcode.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode740 {
	public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int max = 0;
        for(Integer num : nums)
        	max = Math.max(max, num);
		int [] numbers = new int [max + 1];
        for(int i=0;i<nums.length;i++){
        	numbers[nums[i]]++;
        }
		int [] gain = new int [max + 1];
        int [] no_gain = new int [max + 1];
        for(int i=1;i<=max;i++){
        	gain[i] = no_gain[i-1] + i * numbers[i];
        	no_gain[i] = Math.max(gain[i-1], no_gain[i-1]);
        }
        return Math.max(gain[max], no_gain[max]);
    }
	
}
