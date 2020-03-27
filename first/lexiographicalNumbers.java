package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lexiographicalNumbers {
	/**
	 * Lexicographical Order
	 * @param n
	 * @return
	 */
	/*public List<Integer> lexicalOrder(int n) {
        List<Integer>result = new ArrayList<Integer>();
        if(n == 0)
        	return result;
        String [] nums = new String [n];
        for(int i=1;i<=n;i++){
        	nums[i-1] = String.valueOf(i);
        }
        Arrays.sort(nums, new Comparator<String>() {
        	public int compare(String o1, String o2) {
        		char [] chs1 = o1.toCharArray();
        		char [] chs2 = o2.toCharArray();
        		int length = chs1.length >= chs2.length ? chs2.length : chs1.length;
        		for(int i=0;i<length;i++){
    				if(chs1[i] == chs2[i])
    					continue;
    				if(chs1[i] < chs2[i])
    					return -1;
    				if(chs1[i] > chs2[i])
    					return 1;
    			}
        		return 0;
        	}
		});
        
        return result;
    }*/
	
	public List<Integer> lexicalOrder(int n) {
        List<Integer>result = new ArrayList<Integer>();
        for(int i=1;i<10;i++){
        	recursive(result, i, n);
        }
        return result;
    }
	
    private void recursive(List<Integer> list, int target, int num){
    	if(target>num){
    		return;
    	}
    	list.add(target);
    	for(int i=0;i<10;i++){
    		recursive(list, target*10 + i, num);
    	}
    }
}
