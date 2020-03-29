package com.leetcode.one;

public class Leetcode238 {
	public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        /*int [] front = new int [nums.length];
        int [] back = new int [nums.length];
        int [] res = new int [nums.length];
        front[0] = nums[0];
        for(int i=1;i<nums.length;i++){
        	front[i] = nums[i] * front[i-1];
        }
        back[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
        	back[i] = nums[i] * back[i+1];
        }
        res[0] = back[1];
        res[nums.length-1] = front[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
        	res[i] = front[i-1] * back[i+1];
        }*/
        int [] res = new int [nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++){
        	res[i] = nums[i] * res[i-1];
        }
        int last = 1;
        for(int i=nums.length-1;i>=1;i--){
        	res[i] = res[i-1] * last;
        	last *= nums[i];
        }
        res[0] = last;
        return res;
    }
}
