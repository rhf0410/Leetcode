package com.example.second;

import java.util.Stack;

public class Leetcode678 {
	/**
	 * Valid Parenthesis String.
	 * @param s
	 * @return
	 */
	public boolean checkValidString(String s) {
        if(s == null || s.length() == 0)
        	return true;
        Stack<Integer>left = new Stack<Integer>();
        Stack<Integer>star = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == '('){
        		left.push(i);
        	}else if(s.charAt(i) == '*'){
        		star.push(i);
        	}else{
        		if(!left.empty()){
        			left.pop();
        		}else if(!star.empty()){
        			star.pop();
        		}else{
        			return false;
        		}
        	}
        }
        while(!left.empty()&&!star.empty()){
        	if(star.peek() < left.peek()){
        		return false;
        	}else{
        		left.pop();
        		star.pop();
        	}
        }
        return left.empty() == true;
    }
}
