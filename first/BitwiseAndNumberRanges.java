package com.example.first;

public class BitwiseAndNumberRanges {
	/**
	 * Segment tree
	 * @author lenovo
	 *
	 */
	public class SegmentTree {
	    public int start;
	    public int end;
	    public int value;
	    public int lazy;
	    public SegmentTree left;
	    public SegmentTree right;
	    
	    SegmentTree(int start, int end){
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.value = 0;
			this.lazy = 0;
		}
	}
	/**
	 * Building segment tree
	 * @param m:start
	 * @param n:end
	 * @return
	 */
	private SegmentTree buildSegmentTree(int m, int n){
		if(m > n)
			return null;
		SegmentTree root = new SegmentTree(m, n);
		if(m == n){
			SegmentTree st = new SegmentTree(m, n);
			st.value = m;
			return st;
		}else{
			int mid = (m + n) / 2;
			root.left = buildSegmentTree(m, mid);
			root.right = buildSegmentTree(mid + 1, n);
		}
		return root;
	}

	/**
	 * Updating value of segment tree
	 * @param tree:segment tree
	 */
	public void bitwise(SegmentTree tree){
		if(tree.lazy == 0){
			tree.lazy = 1;
		}else{
			tree.value = tree.left.value & tree.right.value;
		}
		if(tree.start == tree.end){
			return;
		}
		bitwise(tree.left);
		bitwise(tree.right);
		if(tree.lazy == 1){
			tree.value = tree.left.value & tree.right.value;
		}
	}
	
	/**
	 * Find the bitwise of all numbers between m and n
	 * @param m:start
	 * @param n:end
	 * @return
	 */
    public int rangeBitwiseAnd(int m, int n) {
        if(m > n){
        	return 0;
        }
        SegmentTree segmentTree = buildSegmentTree(m, n);
        bitwise(segmentTree);
        return segmentTree.value;
    }
}
