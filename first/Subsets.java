package com.example.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
	/**
	 * Subsets.
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
        	return results;
        List<Integer>result = new ArrayList<Integer>();
        results.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length ;i++){
        	for(int j=0;j<i;j++){
        		if(nums[i] < nums[j]){
        			int tnum = nums[i];
        			nums[i] = nums[j];
        			nums[j] = tnum;
        		}
        	}
        }
        helper(nums, 0, results, result);
        return results;
    }
	
	private void helper(int [] nums, int t, List<List<Integer>>results, List<Integer>result){
		for(int i=t;i<nums.length;i++){
			result.add(nums[i]);
			if(!results.contains(result)){
				List<Integer>result1 = new ArrayList<Integer>();
				result1.addAll(result);
				results.add(result1);
			}
			helper(nums, i+1, results, result);
			result.remove(result.size() - 1);
		}
	}
}
