package com.example.first;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
	/**
	 * Word Ladder
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Set<String>visit = new HashSet<String>();
        Set<String>wordSet = new HashSet<String>(wordList);
        visit.add(beginWord);
        while(!visit.contains(endWord)){
        	Set<String>assist = new HashSet<String>();
        	for(String str: visit){
        		for(int i=0;i<str.length();i++){
        			char [] chs = str.toCharArray();
        			for(char ch = 'a';ch<='z';ch++){
        				chs[i] = ch;
        				String new_str = new String(chs);
        				if(wordSet.contains(new_str)){
        					assist.add(new_str);
        					wordSet.remove(new_str);
        				}
        			}
        		}
        	}
        	result++;
        	if(assist.size() == 0)
        		return 0;
        	visit = assist;
        }
        return result;
    }
}
