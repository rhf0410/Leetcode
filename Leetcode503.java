package com.example.second;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode503 {
	/**
	 * Next Greater Element II.
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
        	return new int [0];
        int [] result = new int [nums.length];
        boolean [] isvisit = new boolean[nums.length];
        Stack<Integer>stack = new Stack<Integer>();
        Arrays.fill(result, -1);
        Arrays.fill(isvisit, false);
        for(int i=nums.length - 1;i>=0;i--){
        	while(!stack.isEmpty()&&nums[i]>=stack.peek()){
        		stack.pop();
        	}
        	if(!stack.isEmpty()){
        		result[i] = stack.peek();
        		isvisit[i] = true;
        	}
        	stack.add(nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
        	if(!isvisit[i]){
        		while(!stack.isEmpty() && nums[i] >= stack.peek()){
        			stack.pop();
        		}
        		if(!stack.isEmpty()){
        			result[i] = stack.peek();
        		}
        	}
        }
        return result;
    }
}
