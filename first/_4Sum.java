package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _4Sum {
	/**
	 * Return arrays whose digits can be added into the target
	 * @param arrs:given array
	 * @param target:specified number
	 * @return
	 */
    public List<ArrayList<Integer>> getListfromArray(int [] arrs,int target){
    	List<ArrayList<Integer>>result = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(arrs);
    	for(int i=0;i<arrs.length;i++){
    		ArrayList<Integer>list = new ArrayList<Integer>();
    		int count = 0;
    		int sum = 0;
    		if(addNum(arrs, sum, target, i, count, list)){
    			result.add(list);
    		}
    	}
    	return result;
    }
    
    public boolean addNum(int [] arrs,int sum, int target, int index, int count, ArrayList<Integer> list){
    	if(count == 3){
    		if(sum + arrs[index] == target){
    			list.add(arrs[index]);
        		return true;
    		}else if(sum + arrs[index] > target){
    			return false;
    		}else{
    			return false;
    		}
    	}else{
    		sum += arrs[index];
    		list.add(arrs[index]);
    		return addNum(arrs, sum, target, index + 1, count++, list);
    	}
    }
	
	/**
	 * Return arrays whose digits can be added into the target
	 * @param arrs:given array
	 * @param target:specified number
	 * @return
	 */
	public List<List<Integer>> fourSum(int [] arrs,int target){
		if(arrs == null)
			return null;
		HashSet<ArrayList<Integer>>hashset = new HashSet<ArrayList<Integer>>();
		List<List<Integer>>result = new ArrayList<List<Integer>>();
    	Arrays.sort(arrs);
    	
    	for(int i=0;i<arrs.length;i++){
    		for(int j=i+1;j<arrs.length;j++){
    			int l = j+1;
    			int r = arrs.length - 1;
    			int sum = 0;
    			while(l < r){
    				sum = arrs[i] + arrs[j] + arrs[l] + arrs[r];
    				if(sum < target)
    					l++;
    				if(sum > target)
    					r--;
    				if(sum == target){
    					ArrayList<Integer>list = new ArrayList<Integer>();
    					list.add(arrs[i]);
    					list.add(arrs[j]);
    					list.add(arrs[l]);
    					list.add(arrs[r]);
    					
    					if(!hashset.contains(list)){
    						hashset.add(list);
    						result.add(list);
    					}
    					l++;
    					r--;
    				}
    			}
    		}
    	}
    	return result;
	}
}
