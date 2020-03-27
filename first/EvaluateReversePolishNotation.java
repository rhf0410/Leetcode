package com.example.first;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
        	return 0;
        int result = 0;
        Stack<Integer>integers = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
        		int num1 = integers.pop();
        		int num2 = integers.pop();
        		integers.push(tokens[i].equals("+") ? num2 + num1 : tokens[i].equals("-") ? num2 - num1 : tokens[i].equals("*") ? num2 * num1 : num2 / num1);
        	}else{
        		integers.push(Integer.valueOf(tokens[i]));
        	}
        }
        return integers.pop();
    }
}
