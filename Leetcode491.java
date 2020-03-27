package com.leetcode.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode491 {
	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums == null || nums.length == 0)
			return new ArrayList<List<Integer>>();
		Set<List<Integer>>result = new HashSet<List<Integer>>();
		List<Integer>list = new ArrayList<Integer>();
		recursion(result, nums, 0, list);
		return new ArrayList<List<Integer>>(result);
    }
	
	private void recursion(Set<List<Integer>>result, int [] nums, int begin, List<Integer>list){
		if(list.size() >= 2){
			List<Integer>mid = new ArrayList<Integer>(list);
			result.add(mid);
		}
		if(begin >= nums.length)
			return;
		for(int i=begin;i<nums.length;i++){
			if(!list.isEmpty() && list.get(list.size() - 1) > nums[i])
				continue;
			list.add(nums[i]);
			recursion(result, nums, i+1, list);
			int len = list.size() - 1;
			list.remove(len);
		}
	}
}
