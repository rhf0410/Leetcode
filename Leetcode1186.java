package com.leetcode.one;

public class Leetcode1186 {
	public int maximumSum(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		int max = arr[0];;
		int [] end = new int [arr.length];
		int [] start = new int [arr.length];
		end[0] = arr[0];
		for(int i=1;i<arr.length;i++){
			end[i] = Math.max(arr[i], end[i-1] + arr[i]);
			max = Math.max(max, end[i]);
		}
		start[arr.length - 1] = arr[arr.length - 1];
		for(int i=arr.length - 2;i>=0;i--){
			start[i] = Math.max(arr[i], start[i+1] + arr[i]);
		}
		for(int i=1;i<arr.length-1;i++){
			if(arr[i] < 0)
				max = Math.max(max, start[i+1] + end[i-1]);
		}
		return max;
    }
}
