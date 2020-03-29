package com.example.first;

import java.util.Arrays;

public class _3SumClosest {
	/**
	 * the sum of data close to given number
	 * @param nums : array
	 * @param target : given number
	 * @return
	 */
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null)
        	return 0;
        //sort the given array.
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2] - target;
        for(int i = nums.length - 1;i>=2;i--){
        	if(nums[i] == nums[i-1])
        		continue;
        	min = theMinBetweenThreeNums(nums, i-1, nums[i], min, target);
        }
        return min + target;
    }
    
    /**
     * find the least number between three numbers.
     * @param nums:array
     * @param end:end location
     * @param target:given number
     * @return
     */
    public int theMinBetweenThreeNums(int [] nums,int end,int target,int min,int given){
    	int left = 0;
    	int right = end;
    	while(left<right){
    		if(nums[left] == nums[left + 1]){
    			left++;
    			continue;
    		}
    		if(nums[right] == nums[right - 1]){
    			right--;
    			continue;
    		}
    		min = min> nums[left] + nums[right] + target - given ? nums[left] + nums[right] + target -given : min;
    		if(Math.abs(nums[left] + nums[right] + target) == given)
    				return Math.abs(nums[left] + nums[right] + target);
            if(Math.abs(nums[left] + nums[right] + target) < given){
    			left++;
    		}
            if(Math.abs(nums[left] + nums[right] + target) > given){
    			right--;
    		}
    	}
    	return min;
    }
    
    public int getResult(int[] nums, int target){
    	if(nums == null)
        	return 0;
    	int result = 0;
    	Arrays.sort(nums);
    	result = nums[0] + nums[1] + nums[2] - target;
    	for(int i=0;i<nums.length;i++){
    		int l = i+1;
    		int r = nums.length - 1;
    		while(l<r){
    			int dif = nums[l] + nums[r] + nums[i];
        		result = Math.abs(result) < Math.abs(dif - target) ? result : dif - target;
        		if(dif > target)
        			r--;
        		if(dif < target)
        			l++;
        		if(dif == target)
        			return target;
    		}
    	}
    	return result + target;
    }
}
