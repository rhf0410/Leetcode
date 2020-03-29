package com.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leetcode283 {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
        	return;
        }
        /*int num = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i] != 0)
        		num++;
        }
        int start = 0;
        for(int i=0;i<nums.length && start < num;i++){
        	if(nums[i] != 0){
        		int m = nums[i];
        		nums[i] = nums[start];
        		nums[start] = m;
        		start++;
        	}
        }*/
        int start = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i] != 0){
        		int m = nums[i];
        		nums[i] = nums[start];
        		nums[start] = m;
        		start++;
        	}
        }
    }
}
