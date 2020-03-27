package com.example.first;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        	return -1;
        /*if(nums.length == 1){
        	return nums[0] == target ? 0 : -1;
        }*/
        int index1 = -1, index2 = -1;
        int pivot = -1;
        for(int i=0;i<nums.length-1;i++){
        	if(nums[i] > nums[i+1]){
        		pivot = i;
        		break;
        	}
        }
        if(pivot == -1){
        	return BinarySearch(nums, target, 0, nums.length - 1);
        }else{
        	index1 = BinarySearch(nums, target, 0, pivot);
        	index2 = BinarySearch(nums, target, pivot + 1, nums.length - 1);
        }
        return index1 + index2 + 1;
    }
    
    public int BinarySearch(int [] nums, int target, int begin, int end){
    	while(begin <= end){
    		int mid = (begin + end)/2;
    		if(nums[mid] > target){
    			end = mid - 1;
    		}else if(nums[mid] < target){
    			begin = mid + 1;
    		}else{
    			return mid;
    		}
    	}
    	return -1;
    }
}
