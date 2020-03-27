package com.example.second;

import java.util.Arrays;

public class Leetcode685 {
	/**
	 * Redundant Connection II
	 * @param edges
	 * @return
	 */
	public class Line{
		int x;
		int y;
		
		public Line() {
			
		}
		
		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int[] findRedundantDirectedConnection(int[][] edges) {
		if(edges == null || edges.length == 0){
			return null;
		}
		int len = edges.length;
		int wid = edges[0].length;
		int [] parents = new int [len + 1];
		int [] roots = new int [len + 1];
		int [] size = new int [len + 1];
		Arrays.fill(size, 1);
		
		Line first = new Line();
		Line second = new Line();
		
		for(int i=0;i<edges.length;i++){
			int u = edges[i][0];
			int v = edges[i][1];
			
			if(parents[v] > 0){
				first = new Line(parents[v], v);
				second = new Line(u, v);
				
				edges[i][0] = edges[i][1] = -1;
			}
			parents[v] = u;
		}
		
		for(int i=0;i<edges.length;i++){
			int u = edges[i][0];
			int v = edges[i][1];
			
			if(u < 0 || v < 0){
				continue;
			}
			if(roots[u] == 0){
				roots[u] = u;
			}
			if(roots[v] == 0){
				roots[v] = v;
			}
			int pu = find(u, roots);
			int pv = find(v, roots);
			if(pu == pv){
				return first.x == 0 && first.y == 0 ? edges[i] : new int[]{first.x, first.y};
			}
			if(size[pv] > size[pu]){
				int m  = size[pu];
				size[pu] = size[pv];
				size[pv] = m;
			}
			roots[pv] = pu;
			size[pu] += size[pv];
		}
        return new int[]{second.x, second.y};
    }
	
	private int find(int node, int [] roots){
		while(roots[node] != node){
			roots[node] = roots[roots[node]];
			node  =roots[node];
		}
		return node;
	}
}
