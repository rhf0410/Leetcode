package com.example.first;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * Valid Parentheses.
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
        if(s == null || s.length() == 0)
        	return true;
        Stack<Character>parentheses = new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
        		parentheses.push(s.charAt(i));
        	}else{
        		if(!parentheses.isEmpty()){
        			char ch = parentheses.pop();
            		if(ch == '(' && s.charAt(i) == ')')
            			continue;
            		else if(ch == '[' && s.charAt(i) == ']')
            			continue;
            		else if(ch == '{' && s.charAt(i) == '}')
            			continue;
            		else
            			return false;
        		}else{
        			return false;
        		}
        	}
        }
        return parentheses.isEmpty();
    }
}
