package com.example.first;

import java.util.Arrays;

public class KthLargestElement {
	/**
	 * Kth largest element.
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length)
        	return 0;
        mergeSort(nums, 0, nums.length-1);
        return nums[k-1];
    }
	
	private void merge(int [] nums, int begin, int mid, int end){
		int [] temp = new int [end - begin + 1];
		int i = begin;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= end){
			if(nums[i] > nums[j]){
				temp[k++] = nums[i++];
			}else{
				temp[k++] = nums[j++];
			}
		}
		while(i <= mid)
			temp[k++] = nums[i++];
		while(j <= end)
			temp[k++] = nums[j++];
		for(int k1 = 0;k1<temp.length;k1++)
			nums[k1+begin] = temp[k1];
	}
	
	private void mergeSort(int [] nums, int begin, int end){
		int mid = (begin + end)/2;
		if(begin < end){
			mergeSort(nums, begin, mid);
			mergeSort(nums, mid + 1, end);
			merge(nums, begin, mid, end);
		}
	}
}
