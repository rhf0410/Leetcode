package com.example.first;

import java.util.ArrayList;
import java.util.Collections;

public class MultiplyStrings {
	/**
	 * Multiply big integers
	 * @param num1:first number
	 * @param num2:second number
	 * @return
	 */
    public String multiply(String num1, String num2) {
    	for(int i=0;i<num1.length();i++){
    		if(i == 0 && num1.charAt(i) == '-')
    			continue;
    		if(num1.charAt(i) <'0' || num1.charAt(i) > '9')
    			return null;
    	}
    	for(int i=0;i<num2.length();i++){
    		if(i == 0 && num2.charAt(i) == '-')
    			continue;
    		if(num2.charAt(i) <'0' || num2.charAt(i) > '9')
    			return null;
    	}
        if(num1.charAt(0) == '-' || 
           num2.charAt(0) == '-' || 
           num1.length() >= 110 || 
           num2.length() >= 110)
        	return null;
        if((num1.startsWith("0") && num1.length() > 1) || (num2.startsWith("0") && num2.length() > 1))
        	return null;
        
        if(num1.equals("0") || num2.equals("0"))
        	return "0";
        
        //Store mid numbers
        String result = new String("");
        int length = 0;
        ArrayList<ArrayList<Integer>>lists = new ArrayList<ArrayList<Integer>>();
        for(int i=num2.length()-1,k=0;i>=0;i--,k++){
        	int t = 0;
        	ArrayList<Integer>list = new ArrayList<Integer>();
        	for(int j=0;j<k;j++)
        		list.add(0);
        	for(int j=num1.length()-1;j>=0;j--){
        		int n = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + t;
        		list.add(n%10);
        		t = n/10;
        	}
        	if(t != 0)
        	    list.add(t);
        	length = list.size();
        	lists.add(list);
        }
        
        //Calculating the final result
        ArrayList<Integer>results = new ArrayList<Integer>();
        int extra = 0;
        for(int i=0;i<length;i++){
        	int sum = extra;
        	for(int j=0;j<lists.size();j++){
        		if(i < lists.get(j).size()){
        			sum += lists.get(j).get(i);
        		}else{
        			sum += 0;
        		}
        	}
        	results.add(sum%10);
        	extra = sum/10;
        }
        if(extra != 0)
        	results.add(extra);
        Collections.reverse(results);
        for(int i=0;i<results.size();i++)
        	result += results.get(i).toString();
        return result;
    }
}
