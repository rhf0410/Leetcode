package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CloneGraph {
	  /**
	   * Definition for undirected graph.
	   * @author lenovo
	   *
	   */
	  class UndirectedGraphNode {
	      int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 }
	 
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
        	return null;
        LinkedList<UndirectedGraphNode>queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode>map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        queue.offer(node);
        map.put(node, null);
        while(!queue.isEmpty()){
        	UndirectedGraphNode curr = queue.poll();
        	UndirectedGraphNode copy = new UndirectedGraphNode(curr.label);
        	map.put(curr, copy);
        	for(UndirectedGraphNode next: curr.neighbors){
        		if(!map.containsKey(next)){
        			queue.offer(next);
        			map.put(next, null);
        		}
        	}
        }
        for(UndirectedGraphNode curs:map.keySet()){
        	UndirectedGraphNode node1 = map.get(curs);
        	for(UndirectedGraphNode znode:curs.neighbors){
        		node1.neighbors.add(map.get(znode));
        	}
        }
        return map.get(node);
    }
}
