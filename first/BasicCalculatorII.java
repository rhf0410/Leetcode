package com.example.first;

import java.util.Collections;
import java.util.Stack;

public class BasicCalculatorII {
	/**
	 * Basic Calculator II.
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        int result = 0;
        Stack<Integer>integers = new Stack<Integer>();
        Stack<String>alpha = new Stack<String>();
        s = s.replaceAll(" ", "");
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
        		int start = i;
        		while(i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
        			i++;
        		}
        		integers.add(Integer.valueOf(s.substring(start, i + 1)));
        	}
        	if(s.charAt(i) == '*' || s.charAt(i) == '/'){
        		int start = i+1;
        		while(i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
        			i++;
        		}
        		int num1 = Integer.valueOf(s.substring(start, i + 1));
        		int num2 = integers.pop();
        		if(num1 == 0 && s.charAt(start - 1) == '/')
        			return 0;
        		integers.add(s.charAt(start - 1) == '*' ? num2 * num1 : num2 / num1);
        	}
        	if(s.charAt(i) == '+' || s.charAt(i) == '-'){
        		alpha.add(String.valueOf(s.charAt(i)));
        	}
        }
        Collections.reverse(integers);
        Collections.reverse(alpha);
        while(!alpha.isEmpty()){
        	String str = alpha.pop();
        	int num1 = integers.pop();
        	int num2 = integers.pop();
        	if(str.equals("+")){
        		integers.add(num1 + num2);
        	}else if(str.equals("-")){
        		integers.add(num1 - num2);
        	}
        }
        return integers.pop();
    }
}
