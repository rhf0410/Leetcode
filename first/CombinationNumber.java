package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationNumber {
	/**
	 * Combination Sum.
	 * @author lenovo
	 *
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
        	return null;
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        List<Integer>list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        recursive(target, 0, 0, candidates, result, list);
        return result;
    }
	
	private void recursive(int target, int sum, int t, int[] candidates, List<List<Integer>>result, List<Integer>list){
		for(int i=t;i<candidates.length;i++){
			sum += candidates[i];
			if(sum == target){
				list.add(candidates[i]);
				List<Integer>list1 = new ArrayList<Integer>();
				list1.addAll(list);
				if(!result.contains(list1)){
					result.add(list1);
				}
				list.remove(list.size() - 1);
				sum -= candidates[i];
			}else if(sum < target){
				list.add(candidates[i]);
				recursive(target, sum, i+1, candidates, result, list);
				list.remove(list.size() - 1);
				sum -= candidates[i];
			}else{
				return;
			}
		}
	}
}
