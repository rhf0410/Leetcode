package com.example.first;

import java.util.HashMap;
import java.util.Iterator;

public class ValidAnagram {
	/**
	 * Valid Anagram.
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
        	return false;
        int [] count = new int [27];
        for(int i=0;i<s.length();i++){
        	count[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
        	count[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<count.length;i++){
        	if(count[i] != 0)
        		return false;
        }
        return true;
    }
}
