package com.example.first;

import java.util.Collections;

public class LongestIncreaseSequence {
	/**
	 * Find the longest increase sequence.
	 * @param str
	 */
	public String sollution(String str){
		String result = new String("");
		StringBuilder sb = new StringBuilder();
		if(str == null || str.length() == 0){
			return result;
		}
		int [] dp = dpValue(str);
		int index = 0;
		int max = 0;
		for(int i=0;i<dp.length;i++){
			if(dp[i] > max){
				max = dp[i];
				index = i;
			}
		}
		for(int i=str.length()-1;i>=0;i--){
			if(dp[i] == max){
				sb.append(str.charAt(i));
				max--;
			}
		}
		sb = sb.reverse();
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private int[] dpValue(String value){
		int [] dp = new int [value.length()];
		for(int i=0;i<value.length();i++){
			for(int j=i;j>=0;j--){
				if(value.charAt(j) <= value.charAt(i))
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		return dp;
	}
	
	private int binarySearch(String str, int left, int right, char ch){
		int begin = left;
		int end = right;
		while(begin <= end){
			int mid = (begin + end)/2;
			if(str.charAt(mid) == ch){
				return mid;
			}
			if(str.charAt(mid) < ch){
				begin = left + 1;
			}
			if(str.charAt(mid) > ch){
				end = right - 1;
			}
		}
		return begin;
	}
}
