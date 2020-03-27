package com.example.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode212 {
	/**
	 * Word Search II.
	 * @param board
	 * @param words
	 * @return
	 */
	class TireNode {
		boolean isLeaf;
		Map<Character, TireNode>children;
		
		public TireNode() {
			this.isLeaf = false;
			children = new HashMap<Character, TireNode>();
		}
	}
	
	public List<String> findWords(char[][] board, String[] words) {
        if(board == null || words == null)
        	return new ArrayList<String>();
        Set<String>set = new HashSet<String>();
        TireNode root = new TireNode();
        for(String str : words){
        	this.insert(root, str);
        }
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[i].length;j++){
        		DFS(board, i, j, root, "", set);
        	}
        }
        return new ArrayList<String>(set);
    }
	
	private void DFS(char[][] board, int i, int j, TireNode root, String res, Set<String>set){
		if(i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] == '*')
			return;
		if(root.children.containsKey(board[i][j])){
			res += board[i][j];
			root = root.children.get(board[i][j]);
			if(root.isLeaf){
				set.add(res);
			}
			char temp = board[i][j];
			board[i][j] = '*';
			DFS(board, i-1, j, root, res, set);
			DFS(board, i, j+1, root, res, set);
			DFS(board, i+1, j, root, res, set);
			DFS(board, i, j-1, root, res, set);
			board[i][j] = temp;
		}
		return;
	}
	
	public void insert(TireNode node, String str){
		if(str == null || str.length() == 0)
			return;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(node.children.containsKey(ch)){
				node = node.children.get(ch);
			}else{
				TireNode children = new TireNode();
				node.children.put(ch, node);
			}
		}
		node.isLeaf = true;
	}
	
	public boolean search(TireNode node, String str){
		if(str == null || str.length() == 0)
			return false;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(!node.children.containsKey(ch)){
				return false;
			}else{
				node = node.children.get(ch);
			}
		}
		return true;
	}
}
