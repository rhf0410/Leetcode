package com.leetcode.one;

public class Leetcode75 {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
        	return;
        int start = 0;
        for(int i=0; i< nums.length; i++){
        	if(nums[i] == 0){
        		swap(nums, i, start);
        		start++;
        	}
        }
        for(int i=start; i< nums.length; i++){
        	if(nums[i] == 1){
        		swap(nums, i, start);
        		start++;
        	}
        }
        for(int i=start; i< nums.length; i++){
        	if(nums[i] == 2){
        		swap(nums, i, start);
        		start++;
        	}
        }
        /*for(int i=0;i<nums.length;i++){
        	System.out.println(nums[i] + " ");
        }*/
    }
	
	private void swap(int [] nums, int m, int n){
		int o = nums[m];
		nums[m] = nums[n];
		nums[n] = o;
	}
}
