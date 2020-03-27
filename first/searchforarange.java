package com.example.first;

import java.util.ArrayList;

public class searchforarange {
	/**
	 * search for a range
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] searchRange(int[] nums, int target) {
    	int [] result = new int [2];
    	result[0] = -1;
		result[1] = -1;
    	if(nums == null){
    		return result;
    	}
        ArrayList<Integer>list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
        	list.add(nums[i]);
        }
        if(list.contains(target)){
        	result[0] = list.indexOf(target);
        	result[1] = list.lastIndexOf(target);
        	return result;
        }else{
        	return result;
        }
    }
}
