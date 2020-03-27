package com.example.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	/**
	 * Generare Parentheses
	 * @param n : Given Number
	 * @return
	 */
    /*public List<String> generateParenthesis(int n) {
        if(n ==0) 
        	return null;
        
        List<String>result = new ArrayList<String>();
        String str = new String("");
        for(int i=0;i<n;i++)
        	str += "(";
        for(int i=0;i<n;i++)
        	str += ")";
        result.add(str);
        for(int i=n;i<2 * n - 1;i++){
        	for(int j = n-1;j>=1;j--){
        		str = swap(str, i, j);
        		if(isParenthesesOrNot(str)){
        			result.add(str);
        		}
        		str = swap(str, i, j);
        	}
        }
        return result;
    }
    
    *//**
     * Match or not
     * @param str :Given String
     * @return
     *//*
    public boolean isParenthesesOrNot(String str){
    	if(str == null)
    		return false;
    	
    	boolean result = true;
    	Stack<Character>stack = new Stack<Character>();
    	char [] chars = str.toCharArray();
    	stack.push(chars[0]);
    	for(int i=1;i<str.length();i++){
    		if(chars[i] == '(')
    			stack.push(chars[i]);
    		if(chars[i] == ')' && stack.isEmpty())
    			return false;
    		if(chars[i] == ')' && !stack.isEmpty())
    			stack.pop();
    	}
    	return result;
    }
    
    *//**
     * exchange function
     * @param str : given String
     * @param i : 1st location
     * @param j : 2ed location
     * @return
     *//*
    public String swap(String str, int i, int j){
    	char [] chs = str.toCharArray();
    	char ch = chs[i];
    	chs[i] = chs[j];
    	chs[j] = ch;
    	return String.valueOf(chs);
    }*/
	
	/**
	 * Return all the possible array.
	 * @param n : given number
	 * @return
	 */
	public ArrayList<String> generateParenthesis(int n){
		if(n <= 0)
			return null;
		ArrayList<String>lists = new ArrayList<String>();
		StringBuilder strb = new StringBuilder();
		
		recursive(0, 0, n, strb, lists);
		return lists;
	}
	
	public void recursive(int left, int right, int n, StringBuilder strb, ArrayList<String>lists){
		if(left < right){
			return;
		}
		
		if(left == n && right == n){
			String str = strb.toString();
			lists.add(str);
			return;
		}
		
		if(left < n){
			StringBuilder newstr = new StringBuilder(strb.toString());
			newstr.append("(");
			recursive(left + 1, right, n, newstr, lists);
		}
		
		if(right < n){
			StringBuilder newstr = new StringBuilder(strb.toString());
			newstr.append(")");
			recursive(left, right + 1, n, newstr, lists);
		}
	}
}
