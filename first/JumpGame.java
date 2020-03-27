package com.example.first;

public class JumpGame {
	/**
	 * Jump Game.
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
        int n = nums.length;
        int index = nums.length - 1;
        for(int i=n-2;i>=0;i--){
        	if(i+nums[i] >= index){
        		index = i;
        	}
        }
        return index <= 0;
    }
}
