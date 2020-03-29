package com.example.first;

public class SearchInRotatedArrayII {
	/**
	 * Search number in a rotated array.
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
        boolean flag = false;
        if(nums == null || nums.length == 0)
        	return flag;
        int pivot = 0;
        for(int i=0;i<nums.length - 1;i++){
        	if(nums[i] > nums[i+1]){
        		pivot = i;
        		break;
        	}
        }
        return binarySearch(nums, 0, pivot, target) || binarySearch(nums, pivot + 1, nums.length - 1, target);
    }
	
	/**
	 * Binary search to find target.
	 * @param nums
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	private boolean binarySearch(int [] nums, int left, int right, int target){
		int begin = left;
		int end = right;
		while(begin <= end){
			int mid = (begin + end)/2;
			if(nums[mid] == target)
				return true;
			if(nums[mid] < target)
				begin = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}
}
