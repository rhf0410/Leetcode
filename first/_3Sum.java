package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class _3Sum {
	/**
	 * 3Sums
	 * @param nums:Target Array
	 * @return List of sums
	 *//*
    public List<List<Integer>> threeSum(int[] nums) {
    	if(nums == null)
    		return null;
        List<List<Integer>>list = new ArrayList<List<Integer>>();
        Set<List<Integer>>set = new HashSet<List<Integer>>();
        for(int i=0;i<nums.length;i++){
        	for(int j=0;j<nums.length && j != i;j++){
        		for(int k=0;k<nums.length && k != j && k != i;k++){
        			if(nums[i] + nums[j] + nums[k] == 0){
        				List<Integer>glist = new ArrayList<Integer>();
        				glist.add(nums[i]);
        				glist.add(nums[j]);
        				glist.add(nums[k]);
        				Collections.sort(glist);
        				set.add(glist);
        			}
        		}
        	}
        }
        
        Iterator<List<Integer>> iset = set.iterator();
        while(iset.hasNext()){
        	list.add(iset.next());
        }
        return list;
    }*/
    
    /**
	 * 3Sums
	 * @param nums:Target Array
	 * @return List of sums
	 */
    public List<List<Integer>> threeSum2(int[] nums) {
    	List<List<Integer>>list = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length <= 2)
    		return list;
    	
    	Arrays.sort(nums);
    	for(int i=nums.length - 1;i>=2;i--){
    		if(i < nums.length - 1 && nums[i] == nums[i+1])
    			continue;
    		List<List<Integer>>curres = addTwo(nums,i-1,-nums[i]);
    		for(int j=0;j<curres.size();j++){
    			curres.get(j).add(nums[i]);
    		}
    		list.addAll(curres);
    	}
    	return list;
    }
    
    private List<List<Integer>> addTwo(int [] nums,int end,int target){
    	List<List<Integer>>curres = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length <= 1)
    		return curres;
    	int i = 0;
    	int j = end;
    	while(i < j){
    		if(nums[i] + nums[j] == target){
    			List<Integer>crest = new ArrayList<Integer>();
    			crest.add(nums[i]);
    			crest.add(nums[j]);
    			curres.add(crest);
    			i++;
    			j--;
    			
    			while(i < j && nums[i] == nums[i-1])
    				i++;
    			while(i < j && nums[j] == nums[j+1])
    				j--;
    		}else if(nums[i] + nums[j] > target){
    			j--;
    		}else{
    			i++;
    		}
    	}
    	return curres;
    }
}
