package com.example.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode720 {
	/**
	 * Longest Word in Dictionary.
	 * @param words
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
	
	public int insertNode(String str, Tire root){
		char [] chs = str.toCharArray();
		Tire node = root;
		int max = 0;
		int orig = 0;
		for(int i=0;i<chs.length;i++){
			if(node.map.containsKey(chs[i])){
				orig = node.count;
				node = node.map.get(chs[i]);
				max = Math.max(max, node.count);
			}else{
				Tire newnode  = new Tire();
				node.map.put(chs[i], newnode);
				node = newnode;
			}
		}
		if(orig == 0){
			node.count = 1;
		}else{
			if(max == 0)
				node.count = 1;
			else
				node.count = max+1;
		}
		return node.count;
	}
	
	public String longestWord(String[] words) {
		String result = new String("");
        if(words == null || words.length == 0)
        	return result;
        PriorityQueue<String>prior = new PriorityQueue<String>(words.length, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
        Tire root = new Tire();
        Arrays.sort(words);
        for(String str:words)
        	System.out.print(str + " ");
        System.out.println();
        int max = 0;
        HashMap<Integer, List<String>>resmap = new HashMap<Integer, List<String>>();
        for(String str: words){
        	int ref = insertNode(str, root);
        	max = Math.max(ref, max);
        	if(resmap.containsKey(ref)){
        		resmap.get(ref).add(str);
        	}else{
        		List<String>list = new ArrayList<String>();
        		list.add(str);
        		resmap.put(ref, list);
        	}
        }
        List<String>res = resmap.get(max);
        Iterator<String>ite = res.iterator();
        while(ite.hasNext())
        	//System.out.println(ite.next());
        	prior.add(ite.next());
        return prior.peek();
    }
}
