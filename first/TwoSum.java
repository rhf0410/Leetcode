package com.example.first;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/**
	 * Find the index of two numbers added into one target
	 * @param nums:given array
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];
        if(nums == null)
        	return null;
        
        for(int i=0;i<nums.length;i++){
        	for(int j=0;j<nums.length && j != i;j++){
        		if(nums[i] + nums[j] == target){
        			result[0] = j;
        			result[1] = i;
        			break;
        		}
        	}
        }
        return result;
    }
}

/*int i = 0;
int j = nums.length - 1;
HashMap<Integer,Integer>hash = new HashMap<Integer,Integer>();
for(int k=0;k<nums.length;k++)
	hash.put(nums[k], k);
Arrays.sort(nums);
while(i<j){
	if(nums[i] + nums[j] == target){
		result[0] = hash.get(nums[i]);
		result[1] = hash.get(nums[j]);
		break;
	}else if(nums[i] + nums[j] > target){
		j--;
	}else{
		i++;
	}
}*/
