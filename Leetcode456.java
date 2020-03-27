package com.example.second;

import java.util.Stack;

public class Leetcode456 {
	/**
	 * 132 Pattern.
	 * @param nums
	 * @return
	 */
	public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length == 0)
        	return false;
        boolean result = false;
        int third = Integer.MIN_VALUE;
        Stack<Integer>stack = new Stack<Integer>();
        for(int i=nums.length-1;i>=0;i--){
        	if(nums[i] < third)
        		return true;
        	while(!stack.isEmpty() && nums[i] > stack.peek()){
        		third = Math.max(third, stack.pop());
        	}
        	stack.push(nums[i]);
        }
        return result;
    }
}
