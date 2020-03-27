package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	/**
	 * Combinations.
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0)
        	return null;
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        List<Integer>list = new ArrayList<Integer>();
        int [] nums = new int[n];
        for(int i=0;i<n;i++)
        	nums[i] = i+1;
        recursive(nums, k, 0, list, result);
        return result;
    }
	
	private void recursive(int [] nums, int k, int t, List<Integer>list, List<List<Integer>>result){
		for(int i=t;i<nums.length;i++){
			list.add(nums[i]);
			if(list.size() == k){
				List<Integer>list1 = new ArrayList<Integer>();
				list1.addAll(list);
				result.add(list1);
				list.remove(list.size() - 1);
			}else if(list.size() < k){
				recursive(nums, k, i + 1, list, result);
				list.remove(list.size() - 1);
			}else{
				return;
			}
		}
	}
}
