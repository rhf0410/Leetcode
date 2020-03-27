package com.leetcode.one;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
        	int res = 0;
        	int [] words = new int [257];
        	for(int j=i;j<s.length();j++){
        		if(words[s.charAt(j)] == 0){
        			res++;
        			words[s.charAt(j)]++;
        		}else{
        			break;
        		}
        	}
        	max = Math.max(max, res);
        }
        return max;
    }
}
