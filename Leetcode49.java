package com.example.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Group Anagrams
 * @author lenovo
 *
 */
public class Leetcode49 {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0)
        	return res;
        HashMap<String, List<String>>map = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
        	String ref = this.returnStr(strs[i]);
        	//System.out.println(ref);
        	if(map.containsKey(ref)){
        		map.get(ref).add(strs[i]);
        	}else{
        		List<String>sub = new ArrayList<String>();
        		sub.add(strs[i]);
        		map.put(ref, sub);
        	}
        }
        Iterator<List<String>>ite = map.values().iterator();
        while(ite.hasNext()){
        	res.add(ite.next());
        }
        return res;
    }
	
	private String returnStr(String str){
		char [] chars = str.toCharArray();
		List<Character>list = new ArrayList<Character>();
		for(Character ch:chars){
			list.add(ch);
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
		}
		return sb.toString();
	}
}
