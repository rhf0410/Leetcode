package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNA {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String>result = new ArrayList<String>();
        if(s == null || s.length() == 0)
        	return result;
        Set<String>set = new HashSet<String>();
        Set<String>visit = new HashSet<String>();
        for(int i=0;i<s.length()-9;i++){
        	String substr = s.substring(i, i+10);
        	if(!visit.add(substr)){
        		set.add(substr);
        	}
        }
        return new ArrayList<String>(set);
    }
	
	public List<String> findRepeatedDnaSequences2(String s){
		List<String>result = new ArrayList<String>();
		if(s == null || s.length() == 0)
			return result;
		Set<Integer>firsttime = new HashSet<Integer>();
		Set<Integer>secondtime = new HashSet<Integer>();
		Map<Character, Integer>map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		for(int i=0;i<s.length()-9;i++){
			int value = 0;
			for(int j=i;j<i+10;j++){
				value <<= 2;
				value |= map.get(s.charAt(j));
			}
			if(!firsttime.add(value) && secondtime.add(value)){
				result.add(s.substring(i, i+10));
			}
		}
		return result;
	}
}
