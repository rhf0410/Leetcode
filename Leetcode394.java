package com.example.second;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode394 {
	/**
	 * Decode String.
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		String result = new String("");
        if(s == null || s.length() == 0){
        	return result;
        }
        Stack<String>str_stack = new Stack<String>();
        String newstr = new String("");
        for(int i=s.length()-1;i>=0;i--){
        	if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
        		int end = i+1;
        		while(i-1>=0 && s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9'){
        			i--;
        		}
        		int num = Integer.parseInt(s.substring(i, end));
        		String nstr = new String("");
        		for(int j=0;j<num;j++){
        			nstr += newstr;
        		}
        		str_stack.add(nstr);
        		newstr = new String("");
        	}else if(s.charAt(i) != '['){
        		str_stack.add(s.charAt(i) + "");
        	}else{
        		while(!str_stack.peek().equals("]")){
        			newstr += str_stack.pop();
        		}
        		str_stack.pop();
        	}
        }
        while(!str_stack.isEmpty()){
        	result += str_stack.pop();
        }
        return result;
    }
}
