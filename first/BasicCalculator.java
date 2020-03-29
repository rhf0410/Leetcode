package com.example.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
	/**
	 * Basic calculator.
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        int result = 0;
        Stack<String>news = new Stack<String>();
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == ')'){
        		String newstr = getSubString(news);
        		int newint = subCalculator(newstr);
        		if(!news.isEmpty()){
        			String alp = news.pop();
            		if(newint < 0){
            			if(alp.equals("+")){
            				news.add("-");
            			}
            			if(alp.equals("-")){
            				news.add("+");
            			}
            			news.add(String.valueOf(Math.abs(newint)));
            		}else{
            			news.add(alp);
            			news.add(String.valueOf(newint));
            		}
        		}else{
        			news.add(String.valueOf(newint));
        		}
        	}else{
        		news.add(String.valueOf(s.charAt(i)));
        	}
        }
        String newstrs = ArrayListToString(news);
        if(newstrs.charAt(0) == '-'){
        	result = 0 - subCalculator(newstrs.substring(1, newstrs.length()));
        }else{
        	result = subCalculator(newstrs);
        }
        return result;
    }
	
	private String getSubString(Stack<String>news){
		List<String>list = new ArrayList<String>();
		while(!news.isEmpty()){
			String ch = news.pop();
			if(ch.equals("("))
				break;
			list.add(ch);
		}
		Collections.reverse(list);
		return ArrayListToString(list);
	}
	
	private String ArrayListToString(List<String>list){
		String newstr = new String("");
		Iterator<String>ite = list.iterator();
		while(ite.hasNext()){
			newstr += ite.next();
		}
		return newstr;
	}
	
	public int subCalculator(String s){
		int number = 0;
        Stack<Integer>intgers = new Stack<Integer>();
        Stack<String>alphas = new Stack<String>();
        s = s.replaceAll(" ", "");
        int k = 0;
        for(int i=0;i<s.length();i++){
        	char ch = s.charAt(i);
        	if(ch == '+' || ch == '-'){
        		intgers.add(Integer.parseInt(s.substring(k, i)));
        		k = i + 1;
        		alphas.add(String.valueOf(ch));
        	}
        }
        intgers.add(Integer.parseInt(s.substring(k, s.length())));
        Collections.reverse(intgers);
        Collections.reverse(alphas);
        while(!alphas.isEmpty()){
        	String ch = alphas.pop();
        	int num1 = intgers.pop();
        	int num2 = intgers.pop();
        	if(ch.equals("+")){
        		intgers.add(num1 + num2);
        	}else if(ch.equals("-")){
        		intgers.add(num1 - num2);
        	}
        }
        number = intgers.pop();
        return number;
	}
}
