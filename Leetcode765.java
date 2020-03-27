package com.example.second;

import java.util.Arrays;

public class Leetcode765 {
	public class Union_find{
		int count;
		int [] id;
		int [] size;
		
		public Union_find(int range) {
			this.count = range;
			this.id = new int[range];
			for(int i=0;i<range;i++){
				id[i] = i;
			}
			this.size = new int[range];
			Arrays.fill(this.size, 1);
		}
		
		public int find(int p){
			while(p != this.id[p]){
				this.id[p] = this.id[this.id[p]];
				p = this.id[p];
			}
			return p;
		}
		
		public int get_count(){
			return this.count;
		}
		
		public void union(int p, int q){
			int p1 = this.find(p);
			int q1 = this.find(q);
			if(p1 == q1){
				return;
			}else{
				if(this.size[p1] < this.size[q1]){
					this.id[p1] = q1;
					this.size[q1] += this.size[p1];
				}else{
					this.id[q1] = p1;
					this.size[p1] += this.size[q1];
				}
			}
			this.count-=1;
		}
	}
	
	public int minSwapsCouples(int[] row) {
        if(row == null || row.length == 0){
        	return 0;
        }
        int n = row.length;
        int pairs = n/2;
        Union_find uf = new Union_find(pairs);
        for(int i=0;i<pairs;i++){
        	int p = row[2*i];
        	int q = row[2*i + 1];
        	uf.union(p/2, q/2);
        }
        return pairs - uf.get_count();
    }
}
