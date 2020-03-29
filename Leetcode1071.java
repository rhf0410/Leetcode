package com.leetcode.one;

import java.util.Collections;

public class Leetcode1071 {
	public String gcdOfStrings(String str1, String str2) {
		if(!(str1 + str2).equals(str2 + str1)){
			return "";
		}
		int n = Math.min(str1.length(), str2.length());
		for(int i=n; i>= 1; i--){
			String temp = str1.substring(0, i);
			if(str1.split(temp).length == 0 && str2.split(temp).length == 0)
				return temp;
		}
		return "";
    }
	
	private String getResult(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		if(str2.length() == 0)
			return "";
		if(length1 % length2 == 0){
			int n = length1 / length2;
			String newStr = this.repeatStr(str2, n);
			if(str1.equals(newStr)){
				return str2;
			}
		}
		str2 = str2.substring(0, str2.length() - 1);
		return getResult(str1, str2);
	}
	
	private String repeatStr(String str, int n){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(str);
		}
		return sb.toString();
	}
}
