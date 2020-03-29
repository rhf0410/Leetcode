package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
	List<String>result = new ArrayList<String>();
	private char[][] ref = {{'a', 'b', 'c'},
	                        {'d', 'e', 'f'},
	                        {'g', 'h', 'i'},
	                        {'j', 'k', 'l'},
	                        {'m', 'n', 'o'},
	                        {'p', 'q', 'r', 's'},
	                        {'t', 'u', 'v'},
	                        {'w', 'x', 'y', 'z'}};
	/**
	 * Letter combinations of a phone number.
	 * @param digits
	 * @return
	 */
    public List<String> letterCombinations(String digits) {
    	if(digits == null || digits.length() == 0)
    		return result;
       
        int [] nums = new int [digits.length()];
        for(int i=0;i<digits.length();i++){
        	nums[i] = digits.charAt(i) - '0' - 2;
        }
        digui("", nums, 0, digits.length() - 1);
        return result;
    }
    
    public void digui(String str, int [] nums, int start, int end){
    	if(start == end + 1){
    		result.add(str);
    		return;
    	}else{
    		for(char letter : ref[nums[start]]){
    			String temp = str + letter;
    			digui(temp, nums,start + 1, end);
    		}
    	}
    }
}
