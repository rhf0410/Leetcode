package com.example.first;

public class QuickFind {
	int [] id;
	int [] sz;
	public QuickFind(int n) {
		id = new int [n];
		sz = new int [n];
		for(int i=0;i<n;i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public void union(int n, int m){
		int rootq = this.getRoot(m);
		int rootp = this.getRoot(n);
		if(sz[rootp] >= sz[rootq]){
			id[rootq] = rootp;
			sz[rootp] += sz[rootq];
		}else{
			id[rootp] = rootq;
			sz[rootq] += sz[rootp];
		}
	}
	
	public boolean find(int n, int m){
		return this.getRoot(n) == this.getRoot(m);
	}
	
	public int getRoot(int i){
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
}
