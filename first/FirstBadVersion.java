package com.example.first;

public class FirstBadVersion {
	/**
	 * Find the minimum in a rotated array
	 * @param nums:given array
	 * @return
	 */
    /*public int findMin(int[] nums) {
        if(nums == null)
        	return -1;
        int result = 0;
        boolean ref = true;
        for(int i=0;i<nums.length - 1;i++){
        	if(nums[i] > nums[i+1]){
        		ref = false;
        		result = i+1;
        		break;
        	}
        }
        if(ref)
        	return nums[0];
        else
        	return nums[result];
    }*/
    
    public int findMin(int[] nums){
    	return find(nums, 0, nums.length - 1);
    }
    
    private int find(int [] nums, int low, int high){
    	if(nums[low] <= nums[high])
    		return nums[low];
    	int mid = (low + high)/2;
    	return Math.min(find(nums, 0, mid), find(nums, mid+1,high));
    }
}
