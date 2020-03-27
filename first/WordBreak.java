package com.example.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {
	/**
	 * s can be segmented into sequences or not.
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.offer(0);
		boolean [] visit = new boolean [s.length() + 1];
		visit[0] = true;
		while(!queue.isEmpty()){
			int cur = queue.poll();
			for(int i = cur+1;i<=s.length();i++){
				if(!visit[i] && wordDict.contains(s.substring(cur, i))){
					if(i == s.length())
						return true;
					queue.add(i);
					visit[i] = true;
				}
			}
		}
		return false;
    }
}
