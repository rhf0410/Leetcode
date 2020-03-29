package com.example.first;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	 * Initializing all points
	 * @param length:the length of array
	 * @return
	 */
    public int [] initValue(int length){
    	int [] pointValue = new int [length + 1];
    	for(int i=0;i<length;i++){
    		pointValue[i] = -1;
    	}
    	return pointValue;
    }
    
    /**
     * Union points by height
     * @param root1
     * @param root2
     */
    public void unionbyHeight(int root1, int root2, int [] pointValue){
    	if(findPoint(root1, pointValue) == findPoint(root2, pointValue))
    		return;
    	if(pointValue[root2] < pointValue[root1]){
    		pointValue[root1] = root2;
    	}else{
    		if(pointValue[root1] == pointValue[root2]){
    			pointValue[root1]--;
    		}
    		pointValue[root2] = root1;
    	}
    }
    
    /**
     * find the root of given target
     * @param target
     * @param pointValue
     * @return
     */
    public int findPoint(int target, int [] pointValue){
    	if(pointValue[target] < 0){
    		return target;
    	}
    	return target = findPoint(pointValue[target], pointValue);
    }
    
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        
        Set<Integer>set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        	set.add(nums[i]);
        int i = 0;
        int max = 0;
        while(i < nums.length){
        	if(!set.contains(nums[i] - 1)){
        		int length = 1;
        		int j = nums[i] + 1;
        		while(set.contains(j)){
        			length ++;
        			j++;
        		}
        		if(length > max)
        			max = length;
        	}
        	i++;
        }
        return max;
    }
}
