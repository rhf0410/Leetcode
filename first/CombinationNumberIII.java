package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class CombinationNumberIII {
	/**
	 * Combination Number III.
	 * @param k
	 * @param n
	 * @return
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		if(k <= 0)
			return null;
		int [] nums = new int [10];
		for(int i=1;i<=9;i++)
			nums[i-1] = i;
		List<List<Integer>>result = new ArrayList<List<Integer>>();
		List<Integer>list = new ArrayList<Integer>();
		recursive(nums, n, 0, k, 0, list, result);
        return result;
    }
	
	private void recursive(int [] nums, int n, int t, int k, int sum, List<Integer>list, List<List<Integer>>result){
		for(int i=t;i<nums.length;i++){
			sum += nums[i];
			if(sum == n){
				list.add(nums[i]);
				if(list.size() == k){
					List<Integer>list1 = new ArrayList<Integer>();
					list1.addAll(list);
					result.add(list1);
				}
				sum -= nums[i];
				list.remove(list.size() - 1);
			}else if(sum < n){
				list.add(nums[i]);
				recursive(nums, n, i+1, k, sum, list, result);
				sum -= nums[i];
				list.remove(list.size() - 1);
			}else{
				return;
			}
		}
	}
}
