package com.example.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode721 {
	/**
	 * Account merge.
	 * @param accounts
	 * @return
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>>result = new ArrayList<List<String>>();
        if(accounts == null || accounts.size() == 0){
        	return result;
        }
        Map<String, Integer>map = new HashMap<String, Integer>();
        int [] adj = new int [accounts.size()];
        for(int i=0;i<adj.length;i++){
        	adj[i] = i;
        }
        for(int i=0;i<adj.length;i++){
        	List<String>l = accounts.get(i);
        	for(int j=1;j<l.size();j++){
        		if(map.containsKey(l.get(j))){
        			union(adj, map.get(l.get(j)), i);
        		}
        		map.put(l.get(j), i);
        	}
        }
        boolean []marked = new boolean[adj.length];
        for(int i=0;i<adj.length;i++){
        	if(!marked[i]){
        		Set<String>set = new HashSet<String>();
        		for(int j=0;j<adj.length;j++){
        			if(adj[j] == i){
        				marked[j] = true;
        				for(int k=1;k<accounts.get(j).size();k++){
        					set.add(accounts.get(j).get(k));
        				}
        			}
        		}
        		if(set.size() == 0){
        			continue;
        		}
        		List<String>l = new ArrayList<String>();
        		l.add(accounts.get(i).get(0));
        		List<String>l2 = new ArrayList<String>(set);
        		Collections.sort(l2);
        		l.addAll(l2);
        		result.add(l);
        	}
        }
        return result;
    }
	
	private void union(int [] adj, int i, int j){
		i = find(adj, i);
		j = find(adj, j);
		for(int t = 0;t<adj.length;t++){
			if(adj[t] == i){
				adj[t] = j;
			}
		}
	}
	
	private int find(int [] adj, int i){
		while(adj[i] != i){
			i = adj[i];
		}
		return i;
	}
}
