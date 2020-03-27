package com.example.second;

import java.util.Stack;

public class Leetcode331 {
	/**
	 * Verify Preorder Serialization of a Binary Tree.
	 * @param preorder
	 * @return
	 */
	public boolean isValidSerialization(String preorder) {
        /*if(preorder == null || preorder.length() == 0)
        	return false;
        Stack<Character>stack = new Stack<Character>();
        for(int i=0;i<preorder.length();i+=2){
        	char ch = preorder.charAt(i);
        	if(ch == '#' && stack.peek() == '#'){
        		while(stack.peek() == '#'){
        			stack.pop();
        		}
        		stack.pop();
        		while(stack.peek() == '#'){
            		stack.pop();
            	}
        		stack.add('#');
        	}else{
        		stack.add(ch);
        	}
        }
        if(stack.size() == 1 && stack.peek() == '#')
        	return true;
        else
        	return false;*/
		int indegree = -1;
        preorder += ",";
        for(int i =0; i < preorder.length(); i++)
        {
            if(preorder.charAt(i)!=',') continue;
            indegree++;
            if(indegree > 0) return false;
            if(preorder.charAt(i-1) != '#') indegree -= 2;
        }
        return indegree == 0;
    }
}
