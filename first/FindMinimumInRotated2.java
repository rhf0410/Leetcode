package com.example.first;

import java.util.ArrayList;

public class FindMinimumInRotated2 {
    public int findMin(int[] nums) {
        if(nums == null)
        	return -1;
        ArrayList<Integer>list1 = new ArrayList<Integer>();
        ArrayList<Integer>list2 = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
        	if(nums[i] >= 0){
        		list1.add(nums[i]);
        	}else{
        		list2.add(-nums[i]);
        	}
        }
        
        int [] s1 = BarrelSort(list1);
        int [] s2 = BarrelSort(list2);
        if(s2 != null){
        	int min = 0;
        	for(int i=s2.length-1;i>=0;i--){
        		if(s2[i] > 0){
        			min = - i;
        			break;
        		}
        	}
        	return min;
        }else{
        	int min = 0;
        	for(int i=0;i<s1.length;i++){
        		if(s1[i] > 0){
        			min = i;
        			break;
        		}
        	}
        	return min;
        }
    }
    
    /**
     * Barrel Sort
     * @param nums:given array
     * @return
     */
    private int [] BarrelSort(ArrayList<Integer>list1){
    	if(list1 == null || list1.size() == 0)
    		return null;
    	int max = Integer.MIN_VALUE;
        for(int i=0;i<list1.size();i++){
        	if(list1.get(i) > max)
        		max = list1.get(i);
        }
        int [] arrs = new int[max + 1];
        for(int i=0;i<list1.size();i++){
        	arrs[list1.get(i)]++;
        }
        return arrs;
    }
}
