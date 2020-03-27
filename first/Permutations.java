package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	/**
	 * Permutations.
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		if(nums == null || nums.length == 0)
			return null;
		List<List<Integer>>results = new ArrayList<List<Integer>>();
		permutations(nums, 0, results);
        return results;
    }
	
	private void permutations(int [] nums, int t, List<List<Integer>>results){
		if(t == nums.length - 1){
			List<Integer>result = new ArrayList<Integer>();
			for(int i=0;i<nums.length;i++)
				result.add(nums[i]);
			if(!results.contains(result)){
				results.add(result);
			}
		}
		for(int i=t;i<nums.length;i++){
			swap(nums, i, t);
			permutations(nums, t+1, results);
			swap(nums, i, t);
		}
	}
	
	private void swap(int [] nums, int i, int j){
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
