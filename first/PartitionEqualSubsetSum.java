package com.example.first;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PartitionEqualSubsetSum {
	/**
	 * Partition Equal Subset Sum.
	 * @param nums
	 * @return
	 */
	public boolean canPartition(int[] nums) {
		boolean flag = false;
		if(nums == null || nums.length == 0)
			return flag;
		int sum = 0;
		for(int num:nums){
			sum += num;
		}
		if(sum % 2 == 1)
			return false;
		sum /= 2;
		int [][] dp = new int [nums.length][sum + 1];
		for(int i=nums[0];i<sum+1;i++){
			dp[0][i] = nums[0];
		}
		for(int i=1;i<nums.length;i++){
			for(int j=nums[i];j<sum+1;j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
			}
		}
		return dp[nums.length - 1][sum] == sum ? true : false;
    }
	
	private void recursion(List<List<Integer>>lists, List<Integer>list, int [] nums, int t){
		for(int i=t;i<nums.length;i++){
			list.add(nums[i]);
			if(!lists.contains(list)){
				List<Integer>list1 = new ArrayList<Integer>();
				list1.addAll(list);
				lists.add(list1);
			}
			recursion(lists, list, nums, i+1);
			list.remove(list.size() - 1);
		}
	}
	
	private int getSum(List<Integer>list){
		int result = 0;
		Iterator<Integer>ite = list.iterator();
		while(ite.hasNext()){
			result += ite.next();
		}
		return result;
	}
}
