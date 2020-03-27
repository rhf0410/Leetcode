package com.example.second;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Leetcode14 {
	/**
	 * Longest Common Prefix.
	 * @param strs
	 * @return
	 */
	class Tire{
		boolean isLeaf;
		int count;
		Map<Character, Tire>map;
		public Tire() {
			this.map = new HashMap<Character, Tire>();
			this.count = 0;
			this.isLeaf = false;
		}
	}
	
	public void insertNode(String str, Tire root){
		char [] chs = str.toCharArray();
		Tire node = root;
		for(int i=0;i<chs.length;i++){
			if(node.map.containsKey(chs[i])){
				node = node.map.get(chs[i]);
			}else{
				Tire newnode  = new Tire();
				node.map.put(chs[i], newnode);
				node = newnode;
			}
		}
		node.isLeaf = true;
	}
	
	public String longestCommonPrefix(String[] strs) {
        String result = new String("");
        if(strs == null || strs.length == 0)
        	return result;
        Tire root = new Tire();
        for(String str:strs){
        	if(str.equals(""))
        		return result;
        	this.insertNode(str, root);
        }
        Tire node = root;
        while(node.map.size() == 1 && !node.isLeaf){
        	Iterator<Character>ite = node.map.keySet().iterator();
        	char ch = ite.next();
        	result += String.valueOf(ch);
        	node = node.map.get(ch);
        }
        return result;
    }
}
