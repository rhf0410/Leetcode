package com.example.first;

public class WildcardMatching {
	/**
	 * Judging the match of string by recursion
	 * @param str1:first string
	 * @param str2:second string
	 * @param begin:begin location
	 * @param end:end location
	 * @return
	 */
	private boolean recursion(String str1, String str2, int first, int second){
		if(first == str1.length() && second == str2.length())
			return true;
		if(second >= str2.length() && first < str1.length())
			return false;
		if(first > str1.length() && second < str2.length())
			return false;
		
		if(str2.charAt(second) == '*' && first == str1.length())
			return true;
		
		if(str1.charAt(first) == str2.charAt(second) 
		   || (first < str1.length() && str2.charAt(second) == '?')
		   || ((second < str2.length() && str1.charAt(first) == '?'))){
			return recursion(str1, str2, ++first, ++second);
		}
		
		if(str2.charAt(second) == '*'){
			if(first + 1 < str1.length())
				if(str1.charAt(first) != str1.charAt(first + 1))
				    return recursion(str1, str2, ++first, ++second);
				else
			        return recursion(str1, str2, ++first, second);
		}
		return false;
	}
	
	/**
	 * Matching or not
	 * @param s:first sequence
	 * @param p:next sequence
	 * @return
	 */
    public boolean isMatch(String s, String p) {
        if(s.equals("") && p.equals("")){
        	return false;
        }
        return recursion(s, p, 0, 0);
    }
}
