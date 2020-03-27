package com.example.first;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SingleNumberIII {
	/**
	 * Single Number III.
	 * @param nums
	 * @return
	 */
	public int[] singleNumber(int[] nums) {
        int [] results = new int [2];
        List<Integer>list = new ArrayList<Integer>();
        Set<Integer>set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(set.contains(nums[i])){
        		set.remove(nums[i]);
        	}else{
        		set.add(nums[i]);
        	}
        }
        Iterator<Integer>ite = set.iterator();
        int k = 0;
        while(ite.hasNext()){
        	results[k++] = ite.next();
        }
        return results;
    }
	
	public int[] singleNumber2(int[] nums){
		int [] results = new int [2];
		int bitnumbers = 0;
		for(int i=0;i<nums.length;i++){
			bitnumbers ^= nums[i];
		}
		int a = bitnumbers, b = bitnumbers;
		int mask = 1;
		while((mask&bitnumbers) == 0){
			mask <<= 1;
		}
		for(int i=0;i<nums.length;i++){
			if((mask&nums[i]) == 0){
				a ^= nums[i];
			}else{
				b ^= nums[i];
			}
		}
		results[0] = a;
		results[1] = b;
		return results;
	}
}
