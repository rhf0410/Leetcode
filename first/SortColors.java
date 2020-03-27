package com.example.first;

public class SortColors {
	public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
	
	private void quickSort(int [] nums, int left, int right){
		if(left < right){
			int dp = partition(nums, left, right);
			quickSort(nums, left, dp-1);
			quickSort(nums, dp+1, right);
		}
	}
	
	private int partition(int [] nums, int left, int right){
		int pivot = nums[left];
		while(left < right){
			while(left < right && nums[right] >= pivot){
				right--;
			}
			if(left < right){
				nums[left++] = nums[right];
			}
			while(left < right && nums[left] <= pivot){
				left++;
			}
			if(left < right){
				nums[right--] = nums[left];
			}
		}
		nums[left] = pivot;
		return left;
	}
}
