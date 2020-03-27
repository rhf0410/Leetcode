package com.example.first;

public class StringtoInteger_1 {
	/**
	 * Converting String to Integer.
	 * @param str Target String
	 * @return result converted
	 */
    public int myAtoi(String str) {
    	if(str == null || str.length() == 0)
    		return 0;
    	int result = 0;
    	int i = 0;
    	int sign = 1;
    	int len = str.length();
    	char [] chas = str.toCharArray();
    	
    	while(i<len){
    		if(chas[i] == ' ')
    			i++;
    		else
    			break;
    	}
    	
    	if(chas[i] == '+' || chas[i] == '-')
    		sign = chas[i++] == '+' ? 1 : -1;
    	while(i < len){
    		if(chas[i] < '0' || chas[i] > '9')
    			break;
    		if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && chas[i] - '0' > 7)){
    			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}
    		result = result * 10 + (chas[i++] - '0');
    	}
    	return sign == 1 ? result : -1 * result;
    }
}
