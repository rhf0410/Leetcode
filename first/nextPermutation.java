package com.example.first;

import java.util.Arrays;

public class nextPermutation {
	/**
	 * next permutation
	 * @param nums : given arraies
	 */
    public void nextPermutation(int[] nums) {
    	int i = nums.length - 1, j = i;
    	for(;i>0;i--){
    		if(nums[i] > nums[i-1])
    			break;
    	}
    	if(i == 0){
    		Arrays.sort(nums);
    		return;
    	}
    	for(;j>i;j--){
    		if(nums[j] > nums[i-1]){
    			break;
    		}
    	}
    	swap(nums, i-1, j);
    	Arrays.sort(nums, i, nums.length);
    }
    
    public void swap(int [] nums, int i, int j){
    	int ref = nums[i];
    	nums[i] = nums[j];
    	nums[j] = ref;
    }
}
