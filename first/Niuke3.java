package com.example.first;

import java.util.ArrayList;

public class Niuke3 {
	public ArrayList<ArrayList<Integer>> solution(int [] nums, int num, int ano){
		if(nums == null || nums.length == 0){
			return null;
		}
		ArrayList<ArrayList<Integer>>result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer>list = new ArrayList<Integer>();
		recursive(nums, num, 0, list, 0, result, ano);
		return result;
	}
	
	public void recursive(int [] nums, int num, int t, ArrayList<Integer>list, int sum, ArrayList<ArrayList<Integer>>result, int ano){
		if(list.size() > ano){
			return;
		}
		if(sum == num && list.size() == ano){
			ArrayList<Integer>list1 = new ArrayList<Integer>();
			list1.addAll(list);
			result.add(list1);
		}
		for(int i=t;i<nums.length;i++){
			sum += nums[i];
			list.add(nums[i]);
			recursive(nums, num, i+1, list, sum, result, ano);
			sum -= nums[i];
			list.remove(list.size() - 1);
		}
	}
}
